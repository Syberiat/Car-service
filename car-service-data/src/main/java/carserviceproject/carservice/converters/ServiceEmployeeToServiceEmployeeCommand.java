package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.models.ServiceEmployee;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmployeeToServiceEmployeeCommand implements Converter<ServiceEmployee, ServiceEmployeeCommand> {

    private SpecialityToSpecialityCommand specialityToSpecialityCommand;

    public ServiceEmployeeToServiceEmployeeCommand(SpecialityToSpecialityCommand specialityToSpecialityCommand) {
        this.specialityToSpecialityCommand = specialityToSpecialityCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public ServiceEmployeeCommand convert(ServiceEmployee serviceEmployee) {
        if (serviceEmployee == null) {
            return null;
        }
        ServiceEmployeeCommand serviceEmployeeCommand = new ServiceEmployeeCommand();
        serviceEmployeeCommand.setId(serviceEmployee.getId());
        serviceEmployeeCommand.setLastName(serviceEmployee.getLastName());
        serviceEmployeeCommand.setName(serviceEmployee.getName());
        serviceEmployee.getSpeciality().forEach(p -> serviceEmployeeCommand.getSpecialityCommands().add(specialityToSpecialityCommand.convert(p)));

        return serviceEmployeeCommand;
    }
}
