package heat.controllers;

import heat.dto.ExtendedUserDto;
import heat.dto.UserSettingsDto;
import heat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    ExtendedUserDto register(HttpServletRequest request,
                             @RequestBody UserSettingsDto userSettings) {
        return userService.createUser(userSettings);
    }
}
