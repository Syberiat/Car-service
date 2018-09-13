package carserviceproject.carservice.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ServiceEmployee extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "serviceEmployee_speciality",
            joinColumns = @JoinColumn(name = "serviceEmployer_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> speciality = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    public Set<Speciality> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Speciality> speciality) {
        this.speciality = speciality;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

}
