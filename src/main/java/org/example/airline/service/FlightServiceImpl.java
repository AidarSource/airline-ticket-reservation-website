package org.example.airline.service;

import org.example.airline.dto.FlightDTO;
import org.example.airline.entity.Flight;
import org.example.airline.repos.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl( FlightRepository flightRepository ) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Iterable<FlightDTO> findAllFlights() {
        Iterable<Flight> flights = flightRepository.findAll();
        return StreamSupport.stream(flights.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
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
    public List<FlightDTO> findByFromCityAndToCityAndDepartureDateBetween( String fromCity, String toCity, LocalDate date ) {
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.atTime( LocalTime.MAX );

        List<Flight> flights = flightRepository.findByFromCityAndToCityAndDepartureDateBetween( fromCity, toCity,
                startDateTime, endDateTime);

        return StreamSupport.stream(flights.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> findByFromCityAndToCity( String fromCity, String toCity ) {
        List<Flight> flights = flightRepository.findByFromCityAndToCity(fromCity, toCity);
        return StreamSupport.stream(flights.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO toDto( Flight flight ) {
        FlightDTO dto = new FlightDTO();
        dto.setId( flight.getId() );
        dto.setFromCity( flight.getFromCity() );
        dto.setToCity( flight.getToCity() );
        dto.setAirplane( flight.getAirplane() );
        dto.setDepartureDate( flight.getDepartureDate() );
        dto.setArrivalDate( flight.getArrivalDate() );
        dto.setPrice( flight.getPrice() );

        return dto;
    }
}
