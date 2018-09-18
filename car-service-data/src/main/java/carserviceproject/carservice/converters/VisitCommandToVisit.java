package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.VisitCommand;
import carserviceproject.carservice.models.Visit;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class VisitCommandToVisit implements Converter<VisitCommand, Visit> {

    private ServiceEmplCommandToServiceEmpl servisEmployeeConverter;
    private CarCommandToCar carConverter;

    public VisitCommandToVisit(ServiceEmplCommandToServiceEmpl servisEmployeeConverter, CarCommandToCar carConverter) {
        this.servisEmployeeConverter = servisEmployeeConverter;
        this.carConverter = carConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public Visit convert(VisitCommand visitCommand) {
        if (visitCommand == null) {
            return null;
        }
        Visit visit = new Visit();
        visit.setDateVisit(visitCommand.getDateVisit());
        visit.setServiceEmployee(servisEmployeeConverter.convert(visitCommand.getServiceEmployeeCommand()));
        visit.setCar(carConverter.convert(visitCommand.getCarCommand()));
        visit.setDescription(visitCommand.getDecsription());
        visit.setId(visitCommand.getId());

        return visit;
    }
}
