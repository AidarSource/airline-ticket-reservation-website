package org.example.airline.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class FlightTicket {
    private String fromCity;
    private String toCity;
    private String airplane;
    private String price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private LocalDateTime departureDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private LocalDateTime arrivalDate;

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

    public String getPrice() {
        return price;
    }

    public void setPrice( String price ) {
        this.price = price;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
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
}
