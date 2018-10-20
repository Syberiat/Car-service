package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.CarTypeCommand;
import carserviceproject.carservice.models.CarType;

public interface CarTypeService extends CrudService<CarType, Long> {

    CarTypeCommand saveCarTypeCommand(CarTypeCommand command);

    CarTypeCommand findByIdCarTypeCommand(Long l);
}
