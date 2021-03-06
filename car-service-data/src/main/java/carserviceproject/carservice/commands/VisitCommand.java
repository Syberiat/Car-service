package carserviceproject.carservice.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class VisitCommand {

    private LocalDate dateVisit;
    private String description;
    private CarCommand carCommand;
    private ServiceEmployeeCommand serviceEmployeeCommand;
    private Long id;

    public String toString() {
        return dateVisit + " " + description + " " + carCommand;
    }
}
