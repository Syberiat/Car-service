package carserviceproject.carservice.services.springDataJpa;

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

    private OwnerServiceSDJpaImpl ownerServiceSDJpa;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerServiceSDJpa = new OwnerServiceSDJpaImpl(ownerRepository);
    }

    @Test
    public void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner = new Owner();
        ownerSet.add(owner);

        when(ownerServiceSDJpa.findAll()).thenReturn(ownerSet);
    }
}