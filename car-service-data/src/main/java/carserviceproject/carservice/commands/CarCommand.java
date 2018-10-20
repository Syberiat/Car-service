package carserviceproject.carservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarCommand {

    int age;
    private CarTypeCommand carTypeCommand;
    private OwnerCommand ownerCommand;
    private Long id;

    public String toString() {
        return "" + carTypeCommand;
    }

}
