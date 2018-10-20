package carserviceproject.carservice.services;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.models.ServiceEmployee;
public interface ServiceEmployeeService extends CrudService <ServiceEmployee, Long> {

    ServiceEmployeeCommand saveServiceEployeeCommand(ServiceEmployeeCommand command);

    ServiceEmployeeCommand findByIdServiceEmployeeCommand(Long l);

}
