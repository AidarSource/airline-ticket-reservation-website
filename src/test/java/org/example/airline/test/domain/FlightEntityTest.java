//package org.example.airline.test.domain;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.example.airline.entity.Flight;
//import org.example.airline.repos.FlightRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class FlightEntityTest {
//
//    @Autowired
//    public TestEntityManager entityManager;
//
//    @Autowired
//    FlightRepository flightRepository;
//
//    @Test
//    public void find_no_flights_if_repo_is_empty() {
//        Iterable<Flight> flights = flightRepository.findAll();
//
//        assertThat(flights).isEmpty();
//    }
//
//    @Test
//    public void delete_all_flights() {
//        entityManager.persist( new Flight("Almaty", "Astana", "Airbus A380", 12000,
//                "2022-19-12", "08:10", "2022-12-19", "09:40") );
//        entityManager.persist( new Flight("Astana", "Almaty", "Airbus A380", 12000,
//                "2022-12-19", "08:10", "2022-12-19", "09:40") );
//
//        flightRepository.deleteAll();
//
//        assertThat( flightRepository.findAll()).isEmpty();
//    }
//
//    @Test
//    public void find_all_flights() {
//        Flight flight1 = new Flight("Almaty", "Astana", "Airbus A380", 12000,
//                "2022-12-19", "18:10", "2022-12-19", "19:40");
//        entityManager.persist( flight1 );
//
//        Flight flight2 = new Flight("Astana", "Almaty", "Airbus A380", 12000,
//                "2022-12-19", "18:10", "2022-12-19", "19:40");
//        entityManager.persist( flight2 );
//
//        Iterable<Flight> flights = flightRepository.findAll();
//
//        assertThat(flights).hasSize(2).contains(flight1, flight2);
//    }
//
//    @Test
//    public void find_flight_by_id() {
//        Flight flight1 = new Flight("Almaty", "Astana", "Airbus A380", 12000,
//                "2022-12-19", "08:10", "2022-12-19", "09:40");
//        entityManager.persist( flight1 );
//
//        Flight flight2 = new Flight("Astana", "Almaty", "Airbus A380", 12000,
//                "2022-12-19", "08:10", "2022-12-19", "09:40");
//        entityManager.persist( flight2 );
//
//        Flight getFlight = flightRepository.findById( flight1.getId() );
//
//        assertThat(getFlight).isEqualTo( flight1 );
//    }
//}
