package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.SpecialityCommand;
import carserviceproject.carservice.models.Speciality;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpecialityToSpecialityCommand implements Converter<Speciality, SpecialityCommand> {

    @Synchronized
    @Nullable
    @Override
    public SpecialityCommand convert(Speciality speciality) {

        if (speciality == null) {
            return null;
        }
        SpecialityCommand specialityCommand = new SpecialityCommand();
        specialityCommand.setDescription(speciality.getDescription());
        specialityCommand.setId(speciality.getId());

        return specialityCommand;
    }
}
