package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.models.Car;
import carserviceproject.carservice.repositories.CarRepository;
import carserviceproject.carservice.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class CarServiceSDJpaImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceSDJpaImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car findById(Long aLong) {
        return carRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Car> findAll() {
        Set<Car> cars = new HashSet<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car save(Car object) {
        return carRepository.save(object);
    }

    @Override
    public void delete(Car object) {
        carRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }
}
