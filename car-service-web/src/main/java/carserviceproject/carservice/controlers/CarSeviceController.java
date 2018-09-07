package carserviceproject.carservice.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarSeviceController {

    @RequestMapping(value = "/car-service")
    public String viewCarService (){
        return "carService";
    }
}
