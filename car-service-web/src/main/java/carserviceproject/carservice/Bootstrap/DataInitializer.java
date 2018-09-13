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
    private final CarService carService;
    private final VisitServis visitServis;

    public DataInitializer(OwnerService ownerService, ServiceEmployeeService serviceEmployeeService, CarTypeService carTypeService, SpecialityService specialityService, CarService carService, VisitServis visitServis) {
        this.ownerService = ownerService;
        this.serviceEmployeeService = serviceEmployeeService;
        this.carTypeService = carTypeService;
        this.specialityService = specialityService;
        this.carService = carService;
        this.visitServis = visitServis;
    }
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Visit v1 = new Visit();
        v1.setDescription("naprawa silnika");
        v1.setDate(LocalDate.now());

        Visit v2 = new Visit();
        v1.setDescription("nmalowanie błotnika");
        v1.setDate(LocalDate.now());

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

        CarType ct1 = new CarType();
        ct1.setBrand("BMW");

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
        car2.getVisits().add(v1);
        owner2.getCars().add(car2);
        v1.setCar(car2);
        carTypeService.save(ct1);
        carService.save(car2);
        ownerService.save(owner2);

        Car car1 = new Car();
        car1.setCarType(ct2);
        car1.setAge(LocalDate.now());
        car1.setOwner(owner1);
        owner1.getCars().add(car1);
        car1.getVisits().add(v2);
        carTypeService.save(ct2);
        carService.save(car1);
        ownerService.save(owner1);

        ServiceEmployee se1 = new ServiceEmployee();
        se1.setName("Mateusz");
        se1.setLastName("Jakubowski");
        se1.getSpeciality().add(s1);
        se1.getVisits().add(v1);
        v1.setServiceEmployee(se1);
        visitServis.save(v1);
        specialityService.save(s1);
        serviceEmployeeService.save(se1);


        ServiceEmployee se2 = new ServiceEmployee();
        se2.setName("Winicjusz");
        se2.setLastName("Jakubowski");
        se2.getSpeciality().add(s2);
        se2.getVisits().add(v2);
        visitServis.save(v2);
        specialityService.save(s2);
        serviceEmployeeService.save(se2);

    }
}
