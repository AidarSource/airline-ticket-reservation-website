package org.example.airline.controller;

import org.example.airline.entity.Role;
import org.example.airline.entity.User;
import org.example.airline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser( User user, Map<String, Object> model) {
        User userFromDb = userService.findByUsername( user.getUsername() );

        if(userFromDb != null) {
            model.put("message", "This user already exists");
            return "registration";
        }

        user.setActive( true );
        user.setRoles( Collections.singleton( Role.USER) );
        userService.save(user);

        return "redirect:/login";
    }
}
