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

    public CarType(Long id, String brand) {
        super(id);
        this.brand = brand;
    }

    private String brand;

    public String toString() {
        return "" + brand;
    }
}
