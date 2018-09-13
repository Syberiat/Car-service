package carserviceproject.carservice.repositories;

import carserviceproject.carservice.models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
