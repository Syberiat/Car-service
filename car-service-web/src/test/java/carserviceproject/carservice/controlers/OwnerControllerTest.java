package carserviceproject.carservice.controlers;

import carserviceproject.carservice.models.Owner;
import carserviceproject.carservice.services.OwnerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @Mock
    Model model;

    private OwnerController ownerController;

    @Before
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    void MVCtest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        mockMvc.perform(get("/car-owner"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner"));
    }

    @Test
    void viewOwner() {

        //given
        Set<Owner> owners = new HashSet<>();
        Owner owner = new Owner();
        owners.add(owner);

        //when
        String view = ownerController.viewOwner(model);

        //then
        when(ownerService.findAll()).thenReturn(owners);
        Assert.assertEquals("owner", view);
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("ownersList"), any());
    }
}