package org.example.airline.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromCity;
    private String toCity;
    private String airplane;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime arrivalDate;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    private int price;

    public Flight() {
    }

    public Flight( String fromCity, String toCity, String airplane, int price,
                   LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.airplane = airplane;
        this.price = price;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets( Set<Ticket> tickets ) {
        this.tickets = tickets;
    }

    public void setDepartureDate( LocalDateTime departureDate ) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate( LocalDateTime arrivalDate ) {
        this.arrivalDate = arrivalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public String getAirplane() {
        return airplane;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }

    public void setAirplane( String airplane ) {
        this.airplane = airplane;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity( String fromCity ) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity( String toCity ) {
        this.toCity = toCity;
    }
}
