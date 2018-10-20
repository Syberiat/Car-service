package carserviceproject.carservice.controlers;

import carserviceproject.carservice.commands.CarCommand;
import carserviceproject.carservice.commands.CarTypeCommand;
import carserviceproject.carservice.commands.OwnerCommand;
import carserviceproject.carservice.services.CarService;
import carserviceproject.carservice.services.CarTypeService;
import carserviceproject.carservice.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private CarService carService;
    private OwnerService ownerService;
    private CarTypeService carTypeService;

    public CarController(CarService carService, CarTypeService carTypeService, OwnerService ownerService) {
        this.carService = carService;
        this.carTypeService = carTypeService;
        this.ownerService = ownerService;
    }

    @GetMapping("/car/{id}/showCar")
    public String showCar(@PathVariable String id, Model model) {
        model.addAttribute("car", carService.findByIdCarCommand(new Long(id)));

        return "carView/showCar";
    }

    @GetMapping("/car/new")
    public String newCar(Model model) {
        model.addAttribute("car", new CarCommand());
        return "carView/newCar";
    }

    @PostMapping("/car")
    public String saveOrUpdateCar(@ModelAttribute CarCommand command1, CarTypeCommand carTypeCommand, OwnerCommand ownerCommand) {
        carTypeService.saveCarTypeCommand(carTypeCommand);
        ownerService.saveOwnerCommand(ownerCommand);
        command1.setOwnerCommand(ownerCommand);
        command1.setCarTypeCommand(carTypeCommand);
        CarCommand car = carService.saveCarCommand(command1);

        return "redirect:/car/" + car.getId() + "/showCar";
    }

    @GetMapping("/car/{id}/update")
    public String updateCar(@PathVariable String id, Model model) {
        CarCommand carCommand = carService.findByIdCarCommand(Long.valueOf(id));

        model.addAttribute("car", carCommand);
        model.addAttribute("carType", carCommand.getCarTypeCommand());
        model.addAttribute("owner", carCommand.getOwnerCommand());
        return "carView/newCar";
    }
}
