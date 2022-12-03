package org.example.airline.service;

import org.example.airline.entity.Flight;
import org.example.airline.repos.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl( FlightRepository flightRepository ) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Iterable<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById( Long id) {
        return flightRepository.findById( id );
    }

    @Override
    public void delete( Optional<Flight> flight ) {
        flight.ifPresent( flightRepository::delete );
    }

    @Override
    public void save( Optional<Flight> flight ) {
        flight.ifPresent( flightRepository::save );
    }

    @Override
    public List<Flight> findByFromCityAndToCityAndDepartureDate( String fromCity, String toCity, LocalDateTime searchFlightDate ) {
        return flightRepository.findByFromCityAndToCityAndDepartureDate( fromCity, toCity, searchFlightDate );
    }
}
