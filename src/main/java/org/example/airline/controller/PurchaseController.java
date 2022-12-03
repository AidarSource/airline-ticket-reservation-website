package org.example.airline.controller;

import org.example.airline.entity.Flight;
import org.example.airline.entity.User;
import org.example.airline.service.FlightService;
import org.example.airline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class PurchaseController {

    private final FlightService flightService;

    private final UserService userService;

    public PurchaseController( FlightService flightService, UserService userService ) {
        this.flightService = flightService;
        this.userService = userService;
    }


    @GetMapping("/purchase")
    public String purchase( @RequestParam(name = "id") Long id, Map<String, Object> model ) {

        Optional<Flight> flight = flightService.findById( id );

        model.put("flight", flight);

        return "purchase";
    }

    @PostMapping("/purchase")
    public String process( @RequestParam String username,
                           @RequestParam Long flightId ) {

        User user = userService.findByUsername( username );
        Optional<Flight> flight = flightService.findById( flightId );

        //user.addToTickets( flight );
        flight.ifPresent( x -> user.addToTickets( Optional.of( x ) ) );
        userService.save(user);

        return "redirect:/profile/" + username;
    }
}
