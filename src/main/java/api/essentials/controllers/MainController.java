package api.essentials.controllers;

import api.essentials.interfaces.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final IMainService mainService;

    public MainController(@Qualifier("MainServiceCloud") IMainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping("/api")
    public String getMain(){
        return mainService.mainOperation();
    }
}
