package org.example.airline.controller;

import org.example.airline.entity.User;
import org.example.airline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping("/profile/{username}")
    public String profile( @PathVariable String username, Model model) {

        var user = userService.findByUsername( username );

        model.addAttribute( "tickets", user.getTickets() );

        return "profile";
    }

    @PostMapping("/refund")
    public String refund(@RequestParam String username, @RequestParam int ticketId) {
        User user = userService.findByUsername( username );

        user.removeTicket( ticketId );

        userService.save( user );

        return "redirect:/profile/" + username;
    }
}
