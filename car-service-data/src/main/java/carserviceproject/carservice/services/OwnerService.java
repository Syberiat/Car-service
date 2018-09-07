package carserviceproject.carservice.services;

import carserviceproject.carservice.models.Owner;


public interface OwnerService extends CrudService <Owner, Long> {

    Owner findByLastName( String lastName);
}
