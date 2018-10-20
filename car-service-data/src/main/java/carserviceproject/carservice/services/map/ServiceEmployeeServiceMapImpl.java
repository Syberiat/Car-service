package carserviceproject.carservice.services.map;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.models.ServiceEmployee;
import carserviceproject.carservice.services.ServiceEmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class ServiceEmployeeServiceMapImpl extends AbstractServiceMap<ServiceEmployee, Long> implements ServiceEmployeeService {

    @Override
    public ServiceEmployee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<ServiceEmployee> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public ServiceEmployee save(ServiceEmployee object) {
        return super.save(object);
    }

    @Override
    public void delete(ServiceEmployee object) {
        super.delete(object);
    }

    @Override
    public ServiceEmployeeCommand saveServiceEployeeCommand(ServiceEmployeeCommand command) {
        return null;
    }

    @Override
    public ServiceEmployeeCommand findByIdServiceEmployeeCommand(Long l) {
        return null;
    }
}
