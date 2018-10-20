package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.models.Owner;


public interface OwnerService extends CrudService <Owner, Long> {

    Owner findByLastName( String lastName);

    OwnerCommand saveOwnerCommand(OwnerCommand command);

    OwnerCommand findByIdOwnerCommand(Long l);

}
