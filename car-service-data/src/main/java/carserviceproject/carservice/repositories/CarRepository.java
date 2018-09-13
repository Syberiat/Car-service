package carserviceproject.carservice.repositories;

import carserviceproject.carservice.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
