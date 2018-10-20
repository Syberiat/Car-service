package carserviceproject.carservice.services.map;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.models.Car;
import carserviceproject.carservice.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class CarServiceMapImpl extends AbstractServiceMap<Car, Long> implements CarService {

    @Override
    public Car findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Car> findAll() {
        return super.findAll();
    }

    @Override
    public Car save(Car object) {
        return super.save(object);
    }

    @Override
    public void delete(Car object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public CarCommand saveCarCommand(CarCommand command) {
        return null;
    }

    @Override
    public CarCommand findByIdCarCommand(Long l) {
        return null;
    }

}
