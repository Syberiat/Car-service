package carserviceproject.carservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ServiceEmployeeCommand {

    private Set<SpecialityCommand> specialityCommands = new HashSet<>();
    private Set<VisitCommand> visitCommands = new HashSet<>();
    private Long id;
    private String name;
    private String lastName;

    public String toString() {
        return getName() + " " + getLastName();
    }
}
