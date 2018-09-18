package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.CarTypeCommand;
import carserviceproject.carservice.models.CarType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CarTypeToCarCommand implements Converter<CarType, CarTypeCommand> {

    @Override
    @Nullable
    @Synchronized
    public CarTypeCommand convert(CarType carType) {
        if (carType == null) {
            return null;
        }
        CarTypeCommand carTypeCommand = new CarTypeCommand();
        carTypeCommand.setBrand(carType.getBrand());
        carTypeCommand.setId(carType.getId());

        return carTypeCommand;
    }
}
