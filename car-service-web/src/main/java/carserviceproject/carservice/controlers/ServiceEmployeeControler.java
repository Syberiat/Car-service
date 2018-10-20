package carserviceproject.carservice.controlers;

import carserviceproject.carservice.commands.ServiceEmployeeCommand;
import carserviceproject.carservice.commands.SpecialityCommand;
import carserviceproject.carservice.services.ServiceEmployeeService;
import carserviceproject.carservice.services.SpecialityService;
import carserviceproject.carservice.services.VisitServis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiceEmployeeControler {

    private ServiceEmployeeService serviceEmployeeService;
    private SpecialityService specialityService;
    private VisitServis visitServis;

    public ServiceEmployeeControler(ServiceEmployeeService serviceEmployeeService, SpecialityService specialityService, VisitServis visitServis) {
        this.serviceEmployeeService = serviceEmployeeService;
        this.specialityService = specialityService;
        this.visitServis = visitServis;
    }

    @GetMapping("/serviceEmployee/{id}/showServiceEmployee")
    public String viewServiceEmployee(@PathVariable String id, Model model) {
        model.addAttribute("serviceEmpl", serviceEmployeeService.findById(new Long(id)));

        return "serviceEmployeeView/showServiceEmployee";
    }

    @GetMapping("/serviceEmployee/{id}/update")
    public String updateServiceEmployee(@PathVariable String id, Model model) {

        ServiceEmployeeCommand serviceEmployeeCommand = serviceEmployeeService.findByIdServiceEmployeeCommand(Long.valueOf(id));

        model.addAttribute("serviceEmployee", serviceEmployeeCommand);

        return "serviceEmployeeView/newServiceEmployee";
    }

    @PostMapping("/serviceEmployee")
    public String saveOrUpdateServiceEmployee(@ModelAttribute ServiceEmployeeCommand command, SpecialityCommand specialityCommand) {
        ServiceEmployeeCommand se = serviceEmployeeService.saveServiceEployeeCommand(command);
        specialityService.saveSpecialityCommand(specialityCommand);
        se.getSpecialityCommands().add(specialityCommand);
        return "redirect:/serviceEmployee/" + se.getId() + "/showServiceEmployee";
    }
}
