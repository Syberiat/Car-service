package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.CarTypeCommand;
import carserviceproject.carservice.models.CarType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarTypeCommandToCarType implements Converter<CarTypeCommand, CarType> {

    @Synchronized
    @Nullable
    @Override
    public CarType convert(CarTypeCommand carTypeCommand) {
        if (carTypeCommand == null) {
            return null;
        }
        CarType carType = new CarType();
        carType.setBrand(carTypeCommand.getBrand());
        carType.setId(carTypeCommand.getId());

        return carType;
    }
}
