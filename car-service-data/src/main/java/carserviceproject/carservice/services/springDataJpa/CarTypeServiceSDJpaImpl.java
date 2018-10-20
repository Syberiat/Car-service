package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.CarTypeCommand;
import carserviceproject.carservice.converters.CarTypeCommandToCarType;
import carserviceproject.carservice.converters.CarTypeToCarTypeCommand;
import carserviceproject.carservice.models.CarType;
import carserviceproject.carservice.repositories.CarTypeRepository;
import carserviceproject.carservice.services.CarTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class CarTypeServiceSDJpaImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;
    private CarTypeCommandToCarType carTypeCommandToCarType;
    private CarTypeToCarTypeCommand carTypeToCarTypeCommand;

    public CarTypeServiceSDJpaImpl(CarTypeRepository carTypeRepository, CarTypeCommandToCarType carTypeCommandToCarType, CarTypeToCarTypeCommand carTypeToCarTypeCommand) {
        this.carTypeRepository = carTypeRepository;
        this.carTypeCommandToCarType = carTypeCommandToCarType;
        this.carTypeToCarTypeCommand = carTypeToCarTypeCommand;
    }

    @Override
    public CarType findById(Long aLong) {
        log.debug("finding by id car type");
        return carTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<CarType> findAll() {
        log.debug("finding all car types");
        Set<CarType> carTypes = new HashSet<>();
        carTypeRepository.findAll().forEach(carTypes::add);
        return carTypes;
    }

    @Override
    public CarType save(CarType object) {
        log.debug("saving car type");
        return carTypeRepository.save(object);
    }

    @Override
    public void delete(CarType object) {
        log.debug("deleting car type");
        carTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting car type by id");
        carTypeRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public CarTypeCommand saveCarTypeCommand(CarTypeCommand command) {
        log.debug("saving car type command");
        CarType detachedCarType = carTypeCommandToCarType.convert(command);
        CarType savedCarType = carTypeRepository.save(detachedCarType);

        return carTypeToCarTypeCommand.convert(savedCarType);
    }

    @Transactional
    @Override
    public CarTypeCommand findByIdCarTypeCommand(Long l) {
        log.debug("finding car type command by id");
        return carTypeToCarTypeCommand.convert(findById(l));
    }
}
