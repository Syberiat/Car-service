package carserviceproject.carservice.converters;

import carserviceproject.carservice.commands.SpecialityCommand;
import carserviceproject.carservice.models.Speciality;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpecialityCommandToSpeciality implements Converter<SpecialityCommand, Speciality> {

    @Synchronized
    @Nullable
    @Override
    public Speciality convert(SpecialityCommand o) {

        if (o == null) {
            return null;
        }
        Speciality speciality = new Speciality();
        speciality.setDescription(o.getDescription());
        speciality.setId(o.getId());

        return speciality;
    }
}
