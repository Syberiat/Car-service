package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.converters.ServiceEmplCommandToServiceEmpl;
import carserviceproject.carservice.converters.ServiceEmployeeToServiceEmployeeCommand;
import carserviceproject.carservice.models.ServiceEmployee;
import carserviceproject.carservice.repositories.ServiceEmployeeRepository;
import carserviceproject.carservice.services.ServiceEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class ServiceEmployeeServiceSDJpaImpl implements ServiceEmployeeService {

    private final ServiceEmployeeRepository serviceEmployeeRepository;
    private final ServiceEmployeeToServiceEmployeeCommand serviceEmployeeToServiceEmployeeCommand;
    private final ServiceEmplCommandToServiceEmpl serviceEmplCommandToServiceEmpl;

    public ServiceEmployeeServiceSDJpaImpl(ServiceEmployeeRepository serviceEmployeeRepository, ServiceEmployeeToServiceEmployeeCommand serviceEmployeeToServiceEmployeeCommand, ServiceEmplCommandToServiceEmpl serviceEmplCommandToServiceEmpl) {
        this.serviceEmployeeRepository = serviceEmployeeRepository;
        this.serviceEmployeeToServiceEmployeeCommand = serviceEmployeeToServiceEmployeeCommand;
        this.serviceEmplCommandToServiceEmpl = serviceEmplCommandToServiceEmpl;
    }

    @Override
    public ServiceEmployee findById(Long aLong) {
        log.debug("finding by id service employee");
        return serviceEmployeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<ServiceEmployee> findAll() {
        log.debug("finding all service employee");
        Set<ServiceEmployee> serviceEmployees = new HashSet<>();
        serviceEmployeeRepository.findAll().forEach(serviceEmployees::add);
        return serviceEmployees;
    }

    @Override
    public ServiceEmployee save(ServiceEmployee object) {
        log.debug("saving service employee");
        return serviceEmployeeRepository.save(object);
    }

    @Override
    public void delete(ServiceEmployee object) {
        log.debug("deleting service employee");
        serviceEmployeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting by id service employee");
        serviceEmployeeRepository.deleteById(aLong);
    }

    @Override
    public ServiceEmployeeCommand saveServiceEployeeCommand(ServiceEmployeeCommand command) {
        log.debug("saving service employee command");
        ServiceEmployee se = serviceEmplCommandToServiceEmpl.convert(command);
        ServiceEmployee saved = serviceEmployeeRepository.save(se);

        return serviceEmployeeToServiceEmployeeCommand.convert(saved);
    }

    @Transactional
    @Override
    public ServiceEmployeeCommand findByIdServiceEmployeeCommand(Long l) {
        log.debug("finding by id service employee command");
        return serviceEmployeeToServiceEmployeeCommand.convert(findById(l));
    }
}
