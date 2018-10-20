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
    private CarTypeToCarTypeCommand carTypeConverter;

    public CarToCarCommand(OwnerToOwnerCommand ownerConverter, CarTypeToCarTypeCommand carTypeConverter) {
        this.ownerConverter = ownerConverter;
        this.carTypeConverter = carTypeConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public CarCommand convert(Car car) {

        if (car == null) {
            return null;
        }
        CarCommand carCommand = new CarCommand();
        carCommand.setAge(car.getAge());
        carCommand.setId(car.getId());
        carCommand.setCarTypeCommand(carTypeConverter.convert(car.getCarType()));
        carCommand.setOwnerCommand(ownerConverter.convert(car.getOwner()));

        return carCommand;
    }
}
