package org.example.airline.repos;

import org.example.airline.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByFromCityAndToCityAndDepartureDateBetween(String fromCity, String toCity,
                                                                LocalDateTime startDateTime, LocalDateTime endDateTime);
    List<Flight> findByFromCityAndToCity(String fromCity, String toCity);
}
