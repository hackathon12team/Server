package heat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello!";
    }

}
