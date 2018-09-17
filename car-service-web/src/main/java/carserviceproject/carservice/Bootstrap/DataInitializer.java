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
    private final VisitServis visitServis;
    private final CarService carService;

    public DataInitializer(OwnerService ownerService, ServiceEmployeeService serviceEmployeeService,
                           CarTypeService carTypeService, SpecialityService specialityService, VisitServis visitServis, CarService carService) {
        this.ownerService = ownerService;
        this.serviceEmployeeService = serviceEmployeeService;
        this.carTypeService = carTypeService;
        this.specialityService = specialityService;
        this.visitServis = visitServis;
        this.carService = carService;
    }
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        CarType ct2 = new CarType();
        ct2.setBrand("Mercedes");
        carTypeService.save(ct2);

        CarType ct1 = new CarType();
        ct1.setBrand("BMW");
        carTypeService.save(ct1);

        Speciality s1 = new Speciality();
        s1.setDescription("mechanika samochodowa");
        specialityService.save(s1);

        Speciality s2 = new Speciality();
        s2.setDescription("lakiernictwo-blacharstwo");
        specialityService.save(s2);

        Owner owner1 = new Owner();
        owner1.setName("Ola");
        owner1.setLastName("Walczewska");
        owner1.setAdress("ul. Woronicza");
        owner1.setCity("Warszawa");
        owner1.setPhone("123321111");
        ownerService.save(owner1);

        Car car1 = new Car();
        car1.setCarType(ct2);
        car1.setAge(5);
        car1.setOwner(owner1);
        carService.save(car1);

        Owner owner2 = new Owner();
        owner2.setName("Marysia");
        owner2.setLastName("Okrzasa");
        owner2.setAdress("ul. Zalesiona");
        owner2.setCity("Zalesie Dolne");
        owner2.setPhone("432222321");
        ownerService.save(owner2);

        Car car2 = new Car();
        car2.setCarType(ct1);
        car2.setAge(3);
        car2.setOwner(owner2);
        carService.save(car2);

        ServiceEmployee se1 = new ServiceEmployee();
        se1.setName("Mateusz");
        se1.setLastName("Jakubowski");
        se1.getSpeciality().add(s1);
        serviceEmployeeService.save(se1);

        Visit v1 = new Visit();
        v1.setDescription("naprawa silnika");
        v1.setDateVisit(LocalDate.now());
        v1.setCar(car2);
        v1.setServiceEmployee(se1);
        visitServis.save(v1);

        ServiceEmployee se2 = new ServiceEmployee();
        se2.setName("Winicjusz");
        se2.setLastName("Jakubowski");
        se2.getSpeciality().add(s2);
        serviceEmployeeService.save(se2);

        Visit v2 = new Visit();
        v2.setDescription("malowanie błotnika");
        v2.setDateVisit(LocalDate.now());
        v2.setCar(car1);
        v2.setServiceEmployee(se2);
        visitServis.save(v2);

    }
}
