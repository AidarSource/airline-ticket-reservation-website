package org.example.airline.service;

import org.example.airline.dto.FlightDTO;
import org.example.airline.entity.Flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Iterable<FlightDTO> findAllFlights();
    Optional<Flight> findById( Long id);
    void delete( Optional<Flight> flight);
    void save( Optional<Flight> flight);
    List<FlightDTO> findByFromCityAndToCityAndDepartureDateBetween(String fromCity, String toCity, LocalDate date);
    List<FlightDTO> findByFromCityAndToCity(String fromCity, String toCity);
    FlightDTO toDto(Flight flight);
}
