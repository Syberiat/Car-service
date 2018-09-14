package carserviceproject.carservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ServiceEmployee extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "serviceEmployee_speciality",
            joinColumns = @JoinColumn(name = "serviceEmployee_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();
}
