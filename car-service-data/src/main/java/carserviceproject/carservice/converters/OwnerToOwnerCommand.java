package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.models.Owner;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class OwnerToOwnerCommand implements Converter<Owner, OwnerCommand> {

    CarToCarCommand carConverter;

    public OwnerToOwnerCommand(CarToCarCommand carConverter) {
        this.carConverter = carConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public OwnerCommand convert(Owner owner) {
        if (owner == null) {
            return null;
        }
        OwnerCommand ownerCommand = new OwnerCommand();
        ownerCommand.setAdress(owner.getAdress());
        ownerCommand.setCity(owner.getCity());
        ownerCommand.setId(owner.getId());
        ownerCommand.setPhone(owner.getPhone());
        ownerCommand.setName(owner.getName());
        ownerCommand.setLastName(owner.getLastName());

        owner.getCars().forEach(p -> ownerCommand.getCarCommands().add(carConverter.convert(p)));

        return ownerCommand;
    }
}
