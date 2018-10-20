package carserviceproject.carservice.controlers;

import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.services.CarService;
import carserviceproject.carservice.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OwnerController {

    private OwnerService ownerService;
    private CarService carService;

    public OwnerController(OwnerService ownerService, CarService carService) {
        this.ownerService = ownerService;
        this.carService = carService;
    }

    @GetMapping("/car-owner")
    public String viewOwners(Model model) {

        model.addAttribute("ownersList", ownerService.findAll());
        return "ownerView/showAllOwners";
    }

    @GetMapping("/owner/{id}/showOwner")
    public String viewOwner(@PathVariable String id, Model model) {
        model.addAttribute("owner", ownerService.findById(new Long(id)));

        return "ownerView/showOwner";
    }

    @GetMapping("/owner/{id}/update")
    public String updateOwner(@PathVariable String id, Model model) {
        OwnerCommand ownerCommand = ownerService.findByIdOwnerCommand(Long.valueOf(id));
        model.addAttribute("owner", ownerCommand);

        return "ownerView/newOwner";
    }

    @PostMapping("/owner")
    public String saveOrUpdateOwner(@ModelAttribute OwnerCommand ownerCommand) {
        OwnerCommand ow = ownerService.saveOwnerCommand(ownerCommand);

        return "redirect:/owner/" + ow.getId() + "/showOwner";
    }
}
