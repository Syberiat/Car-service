package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.commands.VisitCommand;
import carserviceproject.carservice.converters.VisitCommandToVisit;
import carserviceproject.carservice.converters.VisitToVisitCommand;
import carserviceproject.carservice.models.Visit;
import carserviceproject.carservice.repositories.VisitRepository;
import carserviceproject.carservice.services.VisitServis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springDataJpa")
public class VisitServiceSDJpaImpl implements VisitServis {

    private final VisitRepository visitRepository;

    private VisitToVisitCommand visitToVisitCommand;
    private VisitCommandToVisit visitCommandToVisit;


    public VisitServiceSDJpaImpl(VisitRepository visitRepository, VisitToVisitCommand visitToVisitCommand, VisitCommandToVisit visitCommandToVisit) {
        this.visitRepository = visitRepository;
        this.visitToVisitCommand = visitToVisitCommand;
        this.visitCommandToVisit = visitCommandToVisit;
    }

    @Override
    public Visit findById(Long aLong) {
        log.debug("finding by id visit");
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        log.debug("finding all visit");
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit save(Visit object) {
        log.debug("saving visit");
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        log.debug("deleting visit");
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        log.debug("deleting by id visit");
        visitRepository.deleteById(aLong);
    }

    @Transactional
    @Override
    public VisitCommand findByIdVisitCommand(Long l) {
        log.debug("finding by id visit command");
        return visitToVisitCommand.convert(findById(l));
    }

    @Transactional
    @Override
    public VisitCommand saveVisitCommand(VisitCommand command) {
        log.debug("saving visit command");
        Visit convertVisit = visitCommandToVisit.convert(command);
        Visit savedVisit = visitRepository.save(convertVisit);
        return visitToVisitCommand.convert(savedVisit);
    }
}
