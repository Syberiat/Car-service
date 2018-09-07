package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "/car-owner")
    public String viewOwner (Model model){

        model.addAttribute("ownersList", ownerService.findAll());
        return "owner";
    }
}
