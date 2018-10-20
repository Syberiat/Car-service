package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.converters.CarCommandToCar;
import carserviceproject.carservice.converters.CarToCarCommand;
import carserviceproject.carservice.models.Car;
import carserviceproject.carservice.repositories.CarRepository;
import carserviceproject.carservice.services.CarService;
import carserviceproject.carservice.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class CarServiceSDJpaImpl implements CarService {

    private final CarRepository carRepository;
    private CarCommandToCar carCommandToCar;
    private CarToCarCommand carToCarCommand;
    private OwnerService ownerService;

    public CarServiceSDJpaImpl(CarRepository carRepository, CarCommandToCar carCommandToCar, CarToCarCommand carToCarCommand) {
        this.carRepository = carRepository;
        this.carCommandToCar = carCommandToCar;
        this.carToCarCommand = carToCarCommand;
    }

    @Override
    public Car findById(Long aLong) {
        log.debug("finding by id car");
        return carRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Car> findAll() {
        log.debug("finding all cars");
        Set<Car> cars = new HashSet<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car save(Car object) {
        log.debug("saving car");
        return carRepository.save(object);
    }

    @Override
    public void delete(Car object) {
        log.debug("deleting car");
        carRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting car by id");
        carRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public CarCommand saveCarCommand(CarCommand command) {
        log.debug("saving car command");
        Car detachedCar = carCommandToCar.convert(command);
        Car savedCar = carRepository.save(detachedCar);
        return carToCarCommand.convert(savedCar);
    }

    @Transactional
    @Override
    public CarCommand findByIdCarCommand(Long l) {
        log.debug("finding car command by id");
        return carToCarCommand.convert(findById(l));
    }

}
