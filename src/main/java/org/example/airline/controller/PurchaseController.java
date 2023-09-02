package org.example.airline.controller;

import org.example.airline.entity.Flight;
import org.example.airline.entity.Ticket;
import org.example.airline.entity.User;
import org.example.airline.service.FlightService;
import org.example.airline.service.TicketService;
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

    private final TicketService ticketService;

    public PurchaseController( FlightService flightService, UserService userService, TicketService ticketService ) {
        this.flightService = flightService;
        this.userService = userService;
        this.ticketService = ticketService;
    }


    @GetMapping("/purchase")
    public String purchase( @RequestParam(name = "id") Long id, Map<String, Object> model ) {
        Optional<Flight> flight = flightService.findById( id );

        flight.ifPresent( x -> model.put("flight", x) );

        //model.put("flight", flight);

        return "purchase";
    }

    @PostMapping("/purchase")
    public String process( @RequestParam String username,
                           @RequestParam Long flightId ) {

        User user = userService.findByUsername( username );
        Optional<Flight> flight = flightService.findById( flightId );

        //user.addToTickets( flight );
        Ticket ticket = new Ticket();
        ticket.setUser( user );
        flight.ifPresent( ticket::setFlight );

        user.getTickets().add( ticket );
        flight.ifPresent( x -> x.getTickets().add( ticket ) );

        //flight.ifPresent( x -> user.addToTickets( Optional.of( x ) ) );

        ticketService.save(ticket);
        //flightService.save(flight);
        //userService.save(user);

        return "redirect:/profile/" + username;
    }
}
