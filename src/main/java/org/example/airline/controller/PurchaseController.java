package org.example.airline.controller;

import org.example.airline.domain.Flight;
import org.example.airline.domain.User;
import org.example.airline.repos.FlightRepo;
import org.example.airline.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class PurchaseController {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/purchase")
    public String purchase( @RequestParam(name = "id", required = false, defaultValue = "1234") String id, Map<String, Object> model ) {

        Flight flight = flightRepo.findById( Integer.parseInt( id ) );

        model.put("flight", flight);

        return "purchase";
    }

    @PostMapping("/purchase")
    public String process( @RequestParam String username,
                           @RequestParam Integer flightId ) {

        System.out.println(username);
        System.out.println(flightId);
        User user = userRepo.findByUsername( username );
        Flight flight = flightRepo.findById( flightId );

        user.addToTickets( flight );
        userRepo.save(user);

        return "redirect:/profile";
    }
}
