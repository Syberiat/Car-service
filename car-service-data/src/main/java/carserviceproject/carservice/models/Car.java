package carserviceproject.carservice.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
