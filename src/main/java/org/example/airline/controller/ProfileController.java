package org.example.airline.controller;

import org.example.airline.domain.Flight;
import org.example.airline.domain.User;
import org.example.airline.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private UserRepo userRepo;

    User user;

    @GetMapping("/profile/{username}")
    public String profile( @PathVariable String username, Model model) {

        User user = userRepo.findByUsername( username );

        model.addAttribute( "tickets", user.getTickets() );

        return "profile";
    }

    @PostMapping("/refund")
    public String refund(@RequestParam String username, @RequestParam int ticketId) {
        User user = userRepo.findByUsername( username );

        user.removeTicket( ticketId );

        userRepo.save( user );

        return "redirect:/profile/" + username;
    }
}
