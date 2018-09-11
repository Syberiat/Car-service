package carserviceproject.carservice.models;

import java.time.LocalDate;

public class Visit extends BasicEntity {

    private LocalDate visit;
    private String description;
    private Car car;

    public LocalDate getVisit() {
        return visit;
    }

    public void setVisit(LocalDate visit) {
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
}
