package carserviceproject.carservice.models;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CarType extends BasicEntity{

    private String brand;
}
