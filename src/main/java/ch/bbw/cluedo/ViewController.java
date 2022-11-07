package ch.bbw.cluedo;

import ch.bbw.cluedo.model.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
    @Autowired
    private final DataService service;

    public ViewController(DataService service) {
        this.service = service;
    }

    @GetMapping("/cluedo")
    public String showView(Model model){
        if(service.getCrime() == null){
            GameLogic.setupNewGame(service, new Crime());
        }
        model.addAttribute("actor", service.getPersons().get(service.getCrime().getActor()));
        return "CluedoView";
    }

    @PostMapping("/cluedo")
    public String updateView(){
        return "CluedoView";
    }

    @GetMapping("/cluedo/list")
    public String showListView(Model model){
        model.addAttribute("persons", service.getPersons());
        model.addAttribute("weapons", service.getWeapons());
        model.addAttribute("rooms", service.getRooms());
        return "CluedoListView";
    }

    @PostMapping("/cluedo/list/reset")
    public String resetListView(){
        service.reset();
        return "redirect:/cluedo/list";
    }
}
