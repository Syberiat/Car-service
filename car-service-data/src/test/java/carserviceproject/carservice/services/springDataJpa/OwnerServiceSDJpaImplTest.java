package carserviceproject.carservice.services.springDataJpa;

import carserviceproject.carservice.converters.OwnerCommandToOwner;
import carserviceproject.carservice.converters.OwnerToOwnerCommand;
import carserviceproject.carservice.models.Owner;
import carserviceproject.carservice.repositories.OwnerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

public class OwnerServiceSDJpaImplTest {

    @Mock
    OwnerRepository ownerRepository;
    OwnerToOwnerCommand ownerToOwnerCommand;
    OwnerCommandToOwner ownerCommandToOwner;

    private OwnerServiceSDJpaImpl ownerServiceSDJpa;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerServiceSDJpa = new OwnerServiceSDJpaImpl(ownerRepository, ownerCommandToOwner, ownerToOwnerCommand);
    }

    @Test
    public void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner = new Owner();
        ownerSet.add(owner);

        when(ownerServiceSDJpa.findAll()).thenReturn(ownerSet);
    }
}