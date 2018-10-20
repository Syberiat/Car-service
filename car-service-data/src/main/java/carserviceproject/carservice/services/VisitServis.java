package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.VisitCommand;
import carserviceproject.carservice.models.Visit;

public interface VisitServis extends CrudService<Visit, Long> {

    VisitCommand findByIdVisitCommand(Long l);

    VisitCommand saveVisitCommand(VisitCommand command);
}
