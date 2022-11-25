package org.example.airline.controller;

import org.example.airline.domain.Flight;
import org.example.airline.domain.User;
import org.example.airline.repos.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @GetMapping("flights")
    public String main(Map<String, Object> model) {
        Iterable<Flight> flights = flightRepo.findAll();


        model.put("flights", flights);

        return "flightManagement";
    }

    @PostMapping("/add")
    public String add( @RequestParam String fromCity, @RequestParam String toCity,
                       @RequestParam String airplane, @RequestParam float price,
                       @RequestParam String departureDate, @RequestParam String departureTime,
                       @RequestParam String arrivalDate, @RequestParam String arrivalTime,
                       Map<String, Object> model) {


        Flight flight = new Flight( fromCity, toCity, airplane, price, departureDate, departureTime, arrivalDate, arrivalTime );

        flightRepo.save(flight);

        Iterable<Flight> flights = flightRepo.findAll();

        model.put("flights", flights);

        return "redirect:/main";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int ticketId) {

        Flight flight = flightRepo.findById( ticketId );

        flightRepo.delete( flight );

        return "redirect:/flights";
    }

    @PostMapping("/save")
    public String save(@RequestParam String fromCity, @RequestParam String toCity, @RequestParam String departureTime,
                       @RequestParam String departureDate, @RequestParam String arrivalTime, @RequestParam String arrivalDate,
                       @RequestParam int flightId, @RequestParam String airplane, @RequestParam float price) {

        Flight flight = flightRepo.findById( flightId );

        flight.setFromCity( fromCity );
        flight.setToCity( toCity );
        flight.setDepartureTime( departureTime );
        flight.setDepartureDate( departureDate );
        flight.setArrivalTime( arrivalTime );
        flight.setArrivalDate( arrivalDate );
        flight.setAirplane( airplane );
        flight.setPrice( price );

        flightRepo.save( flight );

        return "redirect:/flights";
    }
}
