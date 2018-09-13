package carserviceproject.carservice.repositories;

import carserviceproject.carservice.models.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeRepository extends CrudRepository<CarType, Long> {
}
