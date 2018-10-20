package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.models.Car;

public interface CarService extends CrudService <Car, Long> {

    CarCommand saveCarCommand(CarCommand command);

    CarCommand findByIdCarCommand(Long l);

}
