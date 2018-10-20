package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.converters.OwnerCommandToOwner;
import carserviceproject.carservice.converters.OwnerToOwnerCommand;
import carserviceproject.carservice.models.Owner;
import carserviceproject.carservice.repositories.OwnerRepository;
import carserviceproject.carservice.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class OwnerServiceSDJpaImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private OwnerCommandToOwner ownerCommandToOwner;
    private OwnerToOwnerCommand ownerToOwnerCommand;

    public OwnerServiceSDJpaImpl(OwnerRepository ownerRepository, OwnerCommandToOwner ownerCommandToOwner, OwnerToOwnerCommand ownerToOwnerCommand) {
        this.ownerRepository = ownerRepository;
        this.ownerCommandToOwner = ownerCommandToOwner;
        this.ownerToOwnerCommand = ownerToOwnerCommand;
    }

    @Override
    public Owner findByLastName(String lastName) {
        log.debug("finding by last name owner");
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
        log.debug("finding by id owner");
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        log.debug("finding all owners");
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner save(Owner object) {
        log.debug("saving owner");
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        log.debug("deleting owner");
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting owner by id");
        ownerRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public OwnerCommand saveOwnerCommand(OwnerCommand command) {
        log.debug("saving owner command");
        Owner owner = ownerCommandToOwner.convert(command);
        Owner saved = ownerRepository.save(owner);
        return ownerToOwnerCommand.convert(saved);
    }

    @Transactional
    @Override
    public OwnerCommand findByIdOwnerCommand(Long l) {
        log.debug("finding owner command by id");
        return ownerToOwnerCommand.convert(findById(l));
    }

}
