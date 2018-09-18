package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.models.Car;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarToCarCommand implements Converter<Car, CarCommand> {

    private OwnerToOwnerCommand ownerConverter;
    private CarTypeToCarCommand carTypeConverter;
    private VisitToVisitCommand visitConverter;

    public CarToCarCommand(OwnerToOwnerCommand ownerConverter, CarTypeToCarCommand carTypeConverter, VisitToVisitCommand visitConverter) {
        this.ownerConverter = ownerConverter;
        this.carTypeConverter = carTypeConverter;
        this.visitConverter = visitConverter;
    }

    @Override
    @Nullable
    @Synchronized
    public CarCommand convert(Car car) {

        if (car == null) {
            return null;
        }
        CarCommand carCommand = new CarCommand();
        carCommand.setAge(car.getAge());
        carCommand.setId(car.getId());
        carCommand.setCarTypeCommand(carTypeConverter.convert(car.getCarType()));
        carCommand.setOwnerCommand(ownerConverter.convert(car.getOwner()));
        car.getVisits().forEach(p -> carCommand.getVisitCommands().add(visitConverter.convert(p)));

        return carCommand;
    }
}
