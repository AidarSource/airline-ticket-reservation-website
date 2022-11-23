package org.example.airline.controller;

import org.example.airline.domain.Flight;
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

    @PostMapping("flights")
    public String add( @RequestParam String fromCity, @RequestParam String toCity,
                       @RequestParam String airplane, @RequestParam float price,
                       @RequestParam String departureDate, @RequestParam String departureTime,
                       Map<String, Object> model) {


        Flight flight = new Flight( fromCity, toCity, airplane, price, departureDate, departureTime );

        flightRepo.save(flight);

        Iterable<Flight> flights = flightRepo.findAll();

        model.put("flights", flights);

        return "redirect:/main";
    }
}
