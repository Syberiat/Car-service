package carserviceproject.carservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class OwnerCommand {

    private Set<CarCommand> carCommands = new HashSet<>();
    private String adress;
    private String city;
    private String phone;
    private Long id;
    private String name;
    private String lastName;

}
