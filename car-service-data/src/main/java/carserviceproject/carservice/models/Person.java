package carserviceproject.carservice.models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BasicEntity{

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
