package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.models.Owner;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class OwnerCommandToOwner implements Converter<OwnerCommand, Owner> {

    @Synchronized
    @Nullable
    @Override
    public Owner convert(OwnerCommand ownerCommand) {
        if (ownerCommand == null) {
            return null;
        }
        Owner owner = new Owner();
        owner.setAdress(ownerCommand.getAdress());
        owner.setPhone(ownerCommand.getPhone());
        owner.setCity(ownerCommand.getCity());
        owner.setId(ownerCommand.getId());
        owner.setName(ownerCommand.getName());
        owner.setLastName(ownerCommand.getLastName());

        //ownerCommand.getCarCommands().forEach(p -> owner.getCars().add(carConverter.convert(p)));

        return owner;
    }
}
