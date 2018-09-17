package carserviceproject.carservice.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class OwnerTest {

    private Owner owner;

    @Before
    void setUp() {
        owner = new Owner();
    }

    @Test
    void getAdress() {
        owner.setAdress("jakisAdres");
        Assert.assertEquals("jakisAdres", owner.getAdress());
    }
}