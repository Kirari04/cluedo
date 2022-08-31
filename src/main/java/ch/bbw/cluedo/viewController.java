package ch.bbw.cluedo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {
    @GetMapping("/cluedo")
    public String index(){
        return "CluedoView";
    }
}
