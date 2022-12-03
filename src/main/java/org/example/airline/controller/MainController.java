package org.example.airline.controller;

import org.example.airline.entity.Flight;
import org.example.airline.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final FlightService flightService;

    public MainController( FlightService flightService ) {
        this.flightService = flightService;
    }

    @GetMapping("/")
    public String greeting( Map<String, Object> model ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Flight> flights = flightService.findAllFlights();

        model.put("flights", flights);

        return "main";
    }

    @GetMapping("filter")
    public String filter( @RequestParam String toCity, @RequestParam String fromCity,
                          @RequestParam LocalDateTime searchFlightDate, Map<String, Object> model) {

        List<Flight> targetCities =
                flightService.findByFromCityAndToCityAndDepartureDate( fromCity, toCity, searchFlightDate );

        model.put("flights", targetCities);

        return "main";
    }
}
