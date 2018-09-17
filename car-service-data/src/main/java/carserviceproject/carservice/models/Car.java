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
@AllArgsConstructor
//@Builder
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
    private int age;

    public String toString() {

        return carType + " właściciel " + owner;
    }
}
