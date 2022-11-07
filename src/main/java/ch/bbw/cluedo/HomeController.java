package ch.bbw.cluedo;

import ch.bbw.cluedo.model.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
            return "Index";
    }
}
