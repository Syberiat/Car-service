package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.SpecialityCommand;
import carserviceproject.carservice.models.Speciality;

public interface SpecialityService extends CrudService<Speciality, Long> {

    SpecialityCommand saveSpecialityCommand(SpecialityCommand command);

    SpecialityCommand findByIdSpecialityCommand(Long l);
}
