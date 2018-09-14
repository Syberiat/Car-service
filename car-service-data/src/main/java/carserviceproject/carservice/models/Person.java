package carserviceproject.carservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends BasicEntity{

    private String name;
    private String lastName;
}
