package carserviceproject.carservice.Bootstrap;

import carserviceproject.carservice.models.*;
import carserviceproject.carservice.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final ServiceEmployeeService serviceEmployeeService;
    private final CarTypeService carTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(OwnerService ownerService, ServiceEmployeeService serviceEmployeeService, CarTypeService carTypeService, SpecialityService specialityService){
        this.ownerService = ownerService;
        this.serviceEmployeeService = serviceEmployeeService;
        this.carTypeService = carTypeService;
        this.specialityService = specialityService;
    }
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Speciality s1 = new Speciality();
        s1.setDescription("mechanika samochodowa");

        Speciality s2 = new Speciality();
        s2.setDescription("lakiernictwo-blacharstwo");

        Owner owner1 = new Owner();
        owner1.setName("Ola");
        owner1.setLastName("Walczewska");
        owner1.setAdress("ul. Woronicza");
        owner1.setCity("Warszawa");
        owner1.setPhone("123321111");

        CarType ct2 = new CarType();
        ct2.setBrand("Mercedes");

        carTypeService.save(ct2);

        CarType ct1 = new CarType();
        ct1.setBrand("BMW");

        carTypeService.save(ct1);

        Owner owner2 = new Owner();
        owner2.setName("Marysia");
        owner2.setLastName("Okrzasa");
        owner2.setAdress("ul. Zalesiona");
        owner2.setCity("Zalesie Dolne");
        owner2.setPhone("432222321");

        Car car2 = new Car();
        car2.setCarType(ct1);
        car2.setAge(LocalDate.now());
        car2.setOwner(owner2);
        owner1.getCars().add(car2);
        ownerService.save(owner1);

        Car car1 = new Car();
        car1.setCarType(ct2);
        car1.setAge(LocalDate.now());
        car1.setOwner(owner1);
        owner2.getCars().add(car1);
        ownerService.save(owner2);

        Speciality sp1 = new Speciality();
        sp1.setDescription("mechanik");

        Speciality sp2 = new Speciality();
        sp2.setDescription("lakiernik");

        ServiceEmployee se1 = new ServiceEmployee();
        se1.setName("Mateusz");
        se1.setLastName("Jakubowski");
        se1.getSpeciality().add(sp2);
        se1.getSpeciality().add(s1);
        serviceEmployeeService.save(se1);
        specialityService.save(s1);

        ServiceEmployee se2 = new ServiceEmployee();
        se2.setName("Winicjusz");
        se2.setLastName("Jakubowski");
        se2.getSpeciality().add(sp1);
        se2.getSpeciality().add(s2);
        serviceEmployeeService.save(se2);
        specialityService.save(s2);
    }
}
