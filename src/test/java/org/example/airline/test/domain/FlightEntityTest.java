package org.example.airline.test.domain;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.example.airline.Application;
import org.example.airline.domain.Flight;
import org.example.airline.repos.FlightRepo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightEntityTest {

    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    FlightRepo flightRepo;

    @Test
    public void find_no_flights_if_repo_is_empty() {
        Iterable<Flight> flights = flightRepo.findAll();

        assertThat(flights).isEmpty();
    }

    @Test
    public void delete_all_flights() {
        entityManager.persist( new Flight("Almaty", "Astana", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40") );
        entityManager.persist( new Flight("Astana", "Almaty", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40") );

        flightRepo.deleteAll();

        assertThat( flightRepo.findAll()).isEmpty();
    }

    @Test
    public void find_all_flights() {
        Flight flight1 = new Flight("Almaty", "Astana", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40");
        entityManager.persist( flight1 );

        Flight flight2 = new Flight("Astana", "Almaty", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40");
        entityManager.persist( flight2 );

        Iterable<Flight> flights = flightRepo.findAll();

        assertThat(flights).hasSize(2).contains(flight1, flight2);
    }

    @Test
    public void find_flight_by_id() {
        Flight flight1 = new Flight("Almaty", "Astana", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40");
        entityManager.persist( flight1 );

        Flight flight2 = new Flight("Astana", "Almaty", "Airbus A380", 12000,
                "2022-12-19", "08:10", "2022-12-19", "09:40");
        entityManager.persist( flight2 );

        Flight getFlight = flightRepo.findById( flight1.getId() );

        assertThat(getFlight).isEqualTo( flight1 );
    }
}
