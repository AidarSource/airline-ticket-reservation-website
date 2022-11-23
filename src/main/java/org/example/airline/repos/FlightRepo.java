package org.example.airline.repos;

import org.example.airline.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepo extends CrudRepository<Flight, Long> {
    Flight findById(Integer id);
    List<Flight> findByFromCityAndToCityAndDepartureDate(String fromCity, String toCity, String departureDate);
}
