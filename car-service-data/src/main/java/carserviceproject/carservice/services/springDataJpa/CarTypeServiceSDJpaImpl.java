package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.models.CarType;
import carserviceproject.carservice.repositories.CarTypeRepository;
import carserviceproject.carservice.services.CarTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class CarTypeServiceSDJpaImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    public CarTypeServiceSDJpaImpl(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    @Override
    public CarType findById(Long aLong) {
        return carTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<CarType> findAll() {
        Set<CarType> carTypes = new HashSet<>();
        carTypeRepository.findAll().forEach(carTypes::add);
        return carTypes;
    }

    @Override
    public CarType save(CarType object) {
        return carTypeRepository.save(object);
    }

    @Override
    public void delete(CarType object) {
        carTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carTypeRepository.deleteById(aLong);
    }
}
