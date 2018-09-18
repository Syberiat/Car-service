package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.VisitServis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitShowCarController {

    private VisitServis visitServis;

    public VisitShowCarController(VisitServis visitService) {
        this.visitServis = visitService;
    }

    @RequestMapping(value = "car/showCar/{id}")
    public String showCar(@PathVariable String id, Model model) {
        model.addAttribute("visit", visitServis.findById(new Long(id)));

        return "car/showCar";
    }
}
