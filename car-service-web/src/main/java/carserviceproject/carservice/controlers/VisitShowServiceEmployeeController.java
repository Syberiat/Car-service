package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.VisitServis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitShowServiceEmployeeController {

    private VisitServis visitServis;

    public VisitShowServiceEmployeeController(VisitServis visitServis) {
        this.visitServis = visitServis;
    }

    @RequestMapping(value = "/serviceEmployee/showServiceEmployee/{id}")
    public String viewCarService(@PathVariable String id, Model model) {

        model.addAttribute("visit", visitServis.findById(new Long(id)));

        return "serviceEmployee/showServiceEmployee";
    }
}
