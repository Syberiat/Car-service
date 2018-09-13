package carserviceproject.carservice.models;

import javax.persistence.Entity;

@Entity
public class CarType extends BasicEntity{

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
