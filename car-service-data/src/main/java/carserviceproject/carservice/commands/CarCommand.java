package carserviceproject.carservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarCommand {

    int age;
    private CarTypeCommand carTypeCommand;
    private Set<VisitCommand> visitCommands = new HashSet<>();
    private OwnerCommand ownerCommand;
    private Long id;

}
