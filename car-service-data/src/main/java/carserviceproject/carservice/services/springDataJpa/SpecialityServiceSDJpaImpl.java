package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.SpecialityCommand;
import carserviceproject.carservice.converters.SpecialityCommandToSpeciality;
import carserviceproject.carservice.converters.SpecialityToSpecialityCommand;
import carserviceproject.carservice.models.Speciality;
import carserviceproject.carservice.repositories.SpecialityRepository;
import carserviceproject.carservice.services.SpecialityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class SpecialityServiceSDJpaImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;
    private final SpecialityCommandToSpeciality specialityCommandToSpeciality;
    private final SpecialityToSpecialityCommand specialityToSpecialityCommand;

    public SpecialityServiceSDJpaImpl(SpecialityRepository specialityRepository, SpecialityCommandToSpeciality specialityCommandToSpeciality, SpecialityToSpecialityCommand specialityToSpecialityCommand) {
        this.specialityRepository = specialityRepository;
        this.specialityCommandToSpeciality = specialityCommandToSpeciality;
        this.specialityToSpecialityCommand = specialityToSpecialityCommand;
    }

    @Override
    public Speciality findById(Long aLong) {
        log.debug("finding by id speciality");
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Speciality> findAll() {
        log.debug("finding all speciality");
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality save(Speciality object) {
        log.debug("saving speciality");
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        log.debug("deleting speciality");
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting by id speciality");
        specialityRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public SpecialityCommand saveSpecialityCommand(SpecialityCommand command) {
        log.debug("saving speciality command");
        Speciality convertSpeciality = specialityCommandToSpeciality.convert(command);
        Speciality saved = specialityRepository.save(convertSpeciality);
        return specialityToSpecialityCommand.convert(saved);
    }

    @Transactional
    @Override
    public SpecialityCommand findByIdSpecialityCommand(Long l) {
        log.debug("finding by id speciality command");
        return specialityToSpecialityCommand.convert(findById(l));
    }

}
