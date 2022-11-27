package org.example.airline.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fromCity;
    private String toCity;
    private String airplane;

    private String departureDate;
    private String departureTime;

    private String arrivalDate;
    private String arrivalTime;
    private int price;

    public Flight() {
    }

    public Flight( String fromCity, String toCity, String airplane, int price,
                   String departureDate, String departureTime, String arrivalDate, String arrivalTime) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.airplane = airplane;
        this.price = price;
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.departureDate = myFormat.format( fromUser.parse(departureDate) );
        } catch( ParseException e ) {
            e.printStackTrace();
        }
        this.departureTime = departureTime;
        try {
            this.arrivalDate = myFormat.format( fromUser.parse(arrivalDate) );
        } catch( ParseException e ) {
            e.printStackTrace();
        }
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate( String arrivalDate ) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");

        try {
            this.arrivalDate = myFormat.format( fromUser.parse( arrivalDate ) );
        } catch( ParseException e ) {
            System.out.println(e);
        }
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime( String arrivalTime ) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime( String departureTime ) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate( String departureDate ) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");

        try {
            this.departureDate = myFormat.format( fromUser.parse( departureDate ) );
        } catch( ParseException e ) {
            System.out.println(e);
        }
    }

    public String getAirplane() {
        return airplane;
    }

    public float getPrice() {
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
