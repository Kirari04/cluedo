package ch.bbw.cluedo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class viewController {
    @GetMapping("/cluedo")
    public String showView(){
        return "CluedoView";
    }

    @PostMapping("/cluedo")
    public String updateView(){
        return "CluedoView";
    }
}
