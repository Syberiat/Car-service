package carserviceproject.carservice.Bootstrap;

import carserviceproject.carservice.models.Owner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import carserviceproject.carservice.services.OwnerService;

@Component
public class DataInitializer implements CommandLineRunner {

    private OwnerService ownerService;

    public DataInitializer (OwnerService ownerService){
        this.ownerService = ownerService;
    }
    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setName("Ola");
        owner1.setLastName("Walczewska");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Marysia");
        owner2.setLastName("Okrzasa");

        ownerService.save(owner2);
    }
}
