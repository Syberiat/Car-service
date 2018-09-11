package carserviceproject.carservice.models;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private Set<Car> cars = new HashSet<>();

    private String adress;
    private String city;
    private String phone;

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
