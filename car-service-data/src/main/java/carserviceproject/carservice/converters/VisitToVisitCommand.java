package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.VisitCommand;
import carserviceproject.carservice.models.Visit;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class VisitToVisitCommand implements Converter<Visit, VisitCommand> {

    private ServiceEmployeeToServiceEmployeeCommand serviceEmployeeToServiceEmployeeCommand;
    private CarToCarCommand carToCarCommand;

    public VisitToVisitCommand(ServiceEmployeeToServiceEmployeeCommand serviceEmployeeToServiceEmployeeCommand, CarToCarCommand carToCarCommand) {
        this.serviceEmployeeToServiceEmployeeCommand = serviceEmployeeToServiceEmployeeCommand;
        this.carToCarCommand = carToCarCommand;
    }

    @Nullable
    @Synchronized
    @Override
    public VisitCommand convert(Visit visit) {
        if (visit == null) {
            return null;
        }
        VisitCommand visitCommand = new VisitCommand();
        visitCommand.setId(visit.getId());
        visitCommand.setServiceEmployeeCommand(serviceEmployeeToServiceEmployeeCommand.convert(visit.getServiceEmployee()));
        visitCommand.setDecsription(visit.getDescription());
        visitCommand.setDateVisit(visit.getDateVisit());
        visitCommand.setCarCommand(carToCarCommand.convert(visit.getCar()));

        return visitCommand;
    }
}
