package org.example.airline.service;

import org.example.airline.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Iterable<Flight> findAllFlights();
    Optional<Flight> findById( Long id);
    void delete( Optional<Flight> flight);
    void save( Optional<Flight> flight);
    List<Flight> findByFromCityAndToCityAndDepartureDate( String fromCity, String toCity, LocalDateTime searchFlightDate);
}
