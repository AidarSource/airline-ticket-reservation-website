package org.example.airline.controller;

import org.example.airline.entity.Role;
import org.example.airline.entity.User;
import org.example.airline.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize( "hasAuthority('ADMIN')" )
public class UserController {

    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    public String userList( Model model) {
        model.addAttribute("users", userService.findAllUsers());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm( @PathVariable User user, Model model ) {
        model.addAttribute( "user", user );
        model.addAttribute( "roles", Role.values() );

        return "userEdit";
    }

    @PostMapping
    public String userSave( @RequestParam String username,
            @RequestParam Map<String, String> form, @RequestParam("userId") User user ) {
        user.setUsername( username );

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect( Collectors.toSet() );

        user.getRoles().clear();

        for( String key : form.keySet() ) {
            if(roles.contains( key )) {
                user.getRoles().add(Role.valueOf( key ));
            }
        }

        userService.save(user);

        return "redirect:/user";
    }
}
