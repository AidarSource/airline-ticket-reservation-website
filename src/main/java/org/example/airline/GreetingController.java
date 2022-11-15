package org.example.airline;

import org.example.airline.domain.Flight;
import org.example.airline.repos.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private FlightRepo flightRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="", required = false, defaultValue = "world") String name, Map<String, Object> model
    ) {
        model.put( "name", name );
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Flight> flights = flightRepo.findAll();


        model.put("flights", flights);

        return "main";
    }

    @PostMapping
    public String add( @RequestParam String fromCity, @RequestParam String toCity,
                       @RequestParam String airplane, @RequestParam float price,
                       @RequestParam String departureDate, @RequestParam String departureTime,
                       Map<String, Object> model) {


        Flight flight = new Flight( fromCity, toCity, airplane, price, departureDate, departureTime );

        flightRepo.save(flight);

        Iterable<Flight> flights = flightRepo.findAll();

        model.put("flights", flights);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String toCity, @RequestParam String fromCity,
                         @RequestParam String searchFlightDate, Map<String, Object> model) {

        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            searchFlightDate = myFormat.format( fromUser.parse(searchFlightDate) );
        } catch( ParseException e ) {
            e.printStackTrace();
        }

        List<Flight> targetCities =
                flightRepo.findByFromCityAndToCityAndDepartureDate( fromCity, toCity, searchFlightDate );

        model.put("flights", targetCities);

        return "main";
    }
}
