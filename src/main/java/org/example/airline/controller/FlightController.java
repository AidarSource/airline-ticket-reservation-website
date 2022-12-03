package org.example.airline.controller;

import org.example.airline.domain.FlightTicket;
import org.example.airline.entity.Flight;
import org.example.airline.service.FlightService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
//@GetMapping("flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController( FlightService flightService ) {
        this.flightService = flightService;
    }

    @GetMapping("flights")
    public String main(Map<String, Object> model) {
        Iterable<Flight> flights = flightService.findAllFlights();

        model.put("flights", flights);

        return "flightManagement";
    }

    @PostMapping("/add")
    public String add( FlightTicket flightTicket, Map<String, Object> model) {

        Flight flight = new Flight( flightTicket.getFromCity(), flightTicket.getToCity(), flightTicket.getAirplane(),
                Integer.parseInt( flightTicket.getPrice() ), flightTicket.getDepartureDate(), flightTicket.getArrivalDate() );

        flightService.save( Optional.of( flight ) );

        Iterable<Flight> flights = flightService.findAllFlights();

        model.put("flights", flights);

        return "redirect:/main";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam @Param("ticketId") Long ticketId) {

        Optional<Flight> flight = flightService.findById( ticketId );
        flightService.delete( flight );

        return "redirect:/flights";
    }

    @PostMapping("/save")
    public String save( FlightTicket flightTicket, @RequestParam Long flightId) {

        Optional<Flight> flight = flightService.findById( flightId );

        flight.ifPresent( x -> x.setFromCity( flightTicket.getFromCity() ) );
        flight.ifPresent( x -> x.setToCity( flightTicket.getToCity() ) );
        flight.ifPresent( x -> x.setDepartureDate( flightTicket.getDepartureDate() ) );
        flight.ifPresent( x -> x.setArrivalDate( flightTicket.getArrivalDate() ) );
        flight.ifPresent( x -> x.setAirplane( flightTicket.getAirplane() ) );
        flight.ifPresent( x -> x.setPrice( Integer.parseInt( flightTicket.getPrice().replace( ",", "" ) ) ) );

        flightService.save( flight );

        return "redirect:/flights";
    }
}
