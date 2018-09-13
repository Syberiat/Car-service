package carserviceproject.carservice.models;

import javax.persistence.Entity;

@Entity
public class Speciality extends BasicEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
