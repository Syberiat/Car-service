package carserviceproject.carservice.controlers;

import carserviceproject.carservice.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping
    public String showCar(Model model) {
        model.addAttribute("carList", carService.findAll());

        return "car/showCar";
    }
}
