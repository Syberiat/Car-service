package carserviceproject.carservice.services.map;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.models.Owner;
import carserviceproject.carservice.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMapImpl extends AbstractServiceMap<Owner, Long> implements OwnerService {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public OwnerCommand saveOwnerCommand(OwnerCommand command) {
        return null;
    }

    @Override
    public OwnerCommand findByIdOwnerCommand(Long l) {
        return null;
    }
}
