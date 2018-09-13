package carserviceproject.carservice.repositories;

import carserviceproject.carservice.models.ServiceEmployee;
import org.springframework.data.repository.CrudRepository;

public interface ServiceEmployeeRepository extends CrudRepository<ServiceEmployee, Long> {
}
