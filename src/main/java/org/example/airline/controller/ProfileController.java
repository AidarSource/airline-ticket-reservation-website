package org.example.airline.controller;

import org.example.airline.entity.Flight;
import org.example.airline.entity.Ticket;
import org.example.airline.entity.User;
import org.example.airline.service.FlightService;
import org.example.airline.service.TicketService;
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
    private final TicketService ticketService;
    private final FlightService flightService;

    public ProfileController( UserService userService, TicketService ticketService, FlightService flightService ) {
        this.userService = userService;
        this.ticketService = ticketService;
        this.flightService = flightService;
    }

    @GetMapping("/profile/{username}")
    public String profile( @PathVariable String username, Model model) {

        var user = userService.findByUsername( username );

        model.addAttribute( "tickets", user.getTickets() );

        return "profile";
    }

    @PostMapping("/refund")
    public String refund(@RequestParam String username, @RequestParam Long ticketId) {

        Ticket ticket = ticketService.findById( ticketId ).orElseThrow();

        User user = ticket.getUser();
        Flight flight = ticket.getFlight();

        user.getTickets().remove(ticket);
        flight.getTickets().remove(ticket);

        ticketService.deleteById( ticketId );

        return "redirect:/profile/" + username;
    }
}
