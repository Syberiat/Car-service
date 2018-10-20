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
public class ServiceEmployee extends Person{

    public ServiceEmployee(Long id, String name, String lastName, Set<Speciality> speciality, Set<Visit> visits) {
        super(id, name, lastName);
        this.speciality = speciality;
        this.visits = visits;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "serviceEmployee_speciality",
            joinColumns = @JoinColumn(name = "serviceEmployee_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    public String toString() {
        return getName() + " " + getLastName();
    }
}
