package carserviceproject.carservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public class Person extends BasicEntity{

    private String name;
    private String lastName;

    public Person(Long id, String name, String lastName) {
        super(id);
        this.name = name;
        this.lastName = lastName;
    }
}
