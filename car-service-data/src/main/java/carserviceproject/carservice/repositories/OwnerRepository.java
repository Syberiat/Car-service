package carserviceproject.carservice.repositories;

import carserviceproject.carservice.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);
}
