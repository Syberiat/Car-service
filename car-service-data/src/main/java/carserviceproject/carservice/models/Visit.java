package carserviceproject.carservice.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Visit extends BasicEntity {

    //@Temporal()
    private LocalDate visit;
    private String description;

    @ManyToOne
    private ServiceEmployee serviceEmployee;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public LocalDate getDate() {
        return visit;
    }

    public void setDate(LocalDate visit) {
        this.visit = visit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ServiceEmployee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
        serviceEmployee.getVisits().add(this);
    }

}
