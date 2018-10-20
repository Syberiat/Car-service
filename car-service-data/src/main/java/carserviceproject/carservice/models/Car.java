package carserviceproject.carservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@Entity
public class Car extends BasicEntity{

    public Car(Long id, Set<Visit> visits, CarType carType, Owner owner, int age) {
        super(id);
        this.visits = visits;
        this.carType = carType;
        this.owner = owner;
        this.age = age;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Visit> visits = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "car_type_id")
    private CarType carType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    //@Temporal()
    private int age;

    public String toString() {

        return "" + carType;
    }
}
