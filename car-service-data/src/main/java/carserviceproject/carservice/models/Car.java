package carserviceproject.carservice.models;

import java.time.LocalDate;

public class Car extends BasicEntity{

    private CarType carType;
    private Owner owner;
    private LocalDate age;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }
}
