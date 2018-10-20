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

    public CarCommandToCar(OwnerCommandToOwner ownerConverter, CarTypeCommandToCarType carTypeConverter) {
        this.ownerConverter = ownerConverter;
        this.carTypeConverter = carTypeConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public Car convert(CarCommand carCommand) {
        if (carCommand == null) {
            return null;
        }
        Car car = new Car();
        car.setId(carCommand.getId());
        car.setOwner(ownerConverter.convert(carCommand.getOwnerCommand()));
        car.setCarType(carTypeConverter.convert(carCommand.getCarTypeCommand()));
        car.setAge(carCommand.getAge());

        return car;
    }
}
