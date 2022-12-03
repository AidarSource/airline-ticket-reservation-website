package org.example.airline.repos;

import org.example.airline.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    //Optional<Flight> findById(Long id);
    List<Flight> findByFromCityAndToCityAndDepartureDate(String fromCity, String toCity, LocalDateTime departureDate);
}
