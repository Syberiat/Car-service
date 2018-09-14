package carserviceproject.carservice.services.map;

import carserviceproject.carservice.models.CarType;
import carserviceproject.carservice.services.CarTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class CarTypeServiceMapImpl extends AbstractServiceMap<CarType, Long> implements CarTypeService {

    @Override
    public Set<CarType> findAll() {
        return super.findAll();
    }

    @Override
    public CarType findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public CarType save(CarType object) {
        return super.save(object);
    }

    @Override
    public void delete(CarType object) {
        super.delete(object);
    }
}
