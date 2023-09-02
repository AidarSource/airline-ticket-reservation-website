package org.example.airline.controller;

import org.example.airline.dto.FlightDTO;
import org.example.airline.service.FlightService;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class MainController {

    private final FlightService flightService;
    private final MessageSource messageSource;

    public MainController( FlightService flightService, MessageSource messageSource ) {
        this.flightService = flightService;
        this.messageSource = messageSource;
    }

    @ModelAttribute("messages")
    public MessageSource getMessageSource() {
        return messageSource;
    }

    @ModelAttribute("locale")
    public Locale getLocale( HttpServletRequest request) {
        return request.getLocale();
    }

    @GetMapping("/")
    public String greeting( Map<String, Object> model ) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<FlightDTO> flights = flightService.findAllFlights();

        model.put("flights", flights);

        model.put("message", flights.spliterator().getExactSizeIfKnown() + " әуе билеттері табылды");

        return "main";
    }

    @GetMapping("filter")
    public String filter( @RequestParam String toCity, @RequestParam String fromCity,
                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate searchFlightDate, Map<String, Object> model) {

        List<FlightDTO> targetCities =
                flightService.findByFromCityAndToCityAndDepartureDateBetween( fromCity, toCity, searchFlightDate );

        if(targetCities.isEmpty()) {
            Iterable<FlightDTO> flights = flightService.findAllFlights();
            model.put("flights", flights);
            model.put("message", "Nothing was found for your query");
        } else {
            model.put( "flights", targetCities );
            model.put("message", targetCities.spliterator().getExactSizeIfKnown() + " flight found for your query");
        }

        return "main";
    }
}
