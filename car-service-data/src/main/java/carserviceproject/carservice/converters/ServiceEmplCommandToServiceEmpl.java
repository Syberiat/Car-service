package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.models.ServiceEmployee;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ServiceEmplCommandToServiceEmpl implements Converter<ServiceEmployeeCommand, ServiceEmployee> {

    private SpecialityCommandToSpeciality specialityConverter;

    public ServiceEmplCommandToServiceEmpl(SpecialityCommandToSpeciality specialityConverter) {
        this.specialityConverter = specialityConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public ServiceEmployee convert(ServiceEmployeeCommand serviceEmployeeCommand) {
        if (serviceEmployeeCommand == null) {
            return null;
        }
        ServiceEmployee serviceEmployee = new ServiceEmployee();
        serviceEmployee.setLastName(serviceEmployeeCommand.getLastName());
        serviceEmployee.setName(serviceEmployeeCommand.getName());
        serviceEmployee.setId(serviceEmployeeCommand.getId());
        serviceEmployeeCommand.getSpecialityCommands().forEach(p -> serviceEmployee.getSpeciality().add(specialityConverter.convert(p)));

        return serviceEmployee;
    }
}
