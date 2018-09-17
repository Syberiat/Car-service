package carserviceproject.carservice.models;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner extends Person {

    @Builder
    public Owner(Long id, String name, String lastName, Set<Car> cars, String adress, String city, String phone) {
        super(id, name, lastName);
        this.cars = cars;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Car> cars = new HashSet<>();

    private String adress;
    private String city;
    private String phone;

    public String toString() {
        return getName() + " " + getLastName();
    }
}
