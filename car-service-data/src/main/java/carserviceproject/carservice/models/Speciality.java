package carserviceproject.carservice.models;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Speciality extends BasicEntity {

    private String description;

    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }


    @Override
    public String toString() {
        return description;
    }
}
