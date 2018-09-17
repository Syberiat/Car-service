package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.ServiceEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceEmployeeController {

    private ServiceEmployeeService serviceEmployeeService;

    @RequestMapping(value = "/serviceEmployee")
    public String viewCarService(Model model) {
        model.addAttribute("serviceEmployeeList", serviceEmployeeService.findAll());
        return "serviceEmployee";
    }
}
