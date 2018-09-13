package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.models.ServiceEmployee;
import carserviceproject.carservice.repositories.ServiceEmployeeRepository;
import carserviceproject.carservice.services.ServiceEmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class ServiceEmployeeServiceSDJpaImpl implements ServiceEmployeeService {

    private final ServiceEmployeeRepository serviceEmployeeRepository;

    public ServiceEmployeeServiceSDJpaImpl(ServiceEmployeeRepository serviceEmployeeRepository) {
        this.serviceEmployeeRepository = serviceEmployeeRepository;
    }

    @Override
    public ServiceEmployee findById(Long aLong) {
        return serviceEmployeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<ServiceEmployee> findAll() {
        Set<ServiceEmployee> serviceEmployees = new HashSet<>();
        serviceEmployeeRepository.findAll().forEach(serviceEmployees::add);
        return serviceEmployees;
    }

    @Override
    public ServiceEmployee save(ServiceEmployee object) {
        return serviceEmployeeRepository.save(object);
    }

    @Override
    public void delete(ServiceEmployee object) {
        serviceEmployeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        serviceEmployeeRepository.deleteById(aLong);
    }
}
