package org.example.airline.repos;

import org.example.airline.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepo extends CrudRepository<Flight, Long> {
    List<Flight> findByFromCityAndToCityAndDepartureDate(String fromCity, String toCity, String departureDate);
}
