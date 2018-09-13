package carserviceproject.carservice.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car extends BasicEntity{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Visit> visits = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    //@Temporal()
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

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
