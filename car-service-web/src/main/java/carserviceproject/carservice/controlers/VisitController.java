package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.VisitServis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VisitController {

    private VisitServis visitServis;

    public VisitController(VisitServis visitServis) {
        this.visitServis = visitServis;
    }

    @RequestMapping(value = "/visit")
    public String visit(Model model) {
        model.addAttribute("visitList", visitServis.findAll());
        return "visit";
    }
}
