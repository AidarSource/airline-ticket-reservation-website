package org.example.airline.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightDTO {
    private Long id;

    private String fromCity;
    private String toCity;
    private String airplane;

    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String formattedDepartureDate;
    private String formattedArrivalDate;

    private int price;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate( LocalDateTime arrivalDate ) {
        this.arrivalDate = arrivalDate;
        this.formattedArrivalDate = arrivalDate.format( DateTimeFormatter.ofPattern("d MMMM HH:mm, yyyy") );
    }

    public int getPrice() {
        return price;
    }

    public String getFormattedDepartureDate() {
        return formattedDepartureDate;
    }

    public String getFormattedArrivalDate() {
        return formattedArrivalDate;
    }

    public void setPrice( int price ) {
        this.price = price;
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

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane( String airplane ) {
        this.airplane = airplane;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate( LocalDateTime departureDate ) {
        this.departureDate = departureDate;
        this.formattedDepartureDate = departureDate.format( DateTimeFormatter.ofPattern("d MMMM HH:mm, yyyy") );
    }
}
