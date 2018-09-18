package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.models.Car;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CarCommandToCar implements Converter<CarCommand, Car> {
    private OwnerCommandToOwner ownerConverter;
    private CarTypeCommandToCarType carTypeConverter;
    private VisitCommandToVisit visitConverter;

    public CarCommandToCar(OwnerCommandToOwner ownerConverter, CarTypeCommandToCarType carTypeConverter, VisitCommandToVisit visitConverter) {
        this.ownerConverter = ownerConverter;
        this.carTypeConverter = carTypeConverter;
        this.visitConverter = visitConverter;
    }

    @Override
    @Synchronized
    @Nullable
    public Car convert(CarCommand carCommand) {
        if (carCommand == null) {
            return null;
        }
        Car car = new Car();
        car.setId(carCommand.getId());
        car.setOwner(ownerConverter.convert(carCommand.getOwnerCommand()));
        car.setCarType(carTypeConverter.convert(carCommand.getCarTypeCommand()));
        car.setAge(carCommand.getAge());
        carCommand.getVisitCommands().forEach(p -> car.getVisits().add(visitConverter.convert(p)));

        return car;
    }
}
