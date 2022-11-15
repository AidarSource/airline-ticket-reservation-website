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
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date arrival;
    private float price;

    public Flight() {
    }

    public Flight( String fromCity, String toCity, String airplane, float price, String departureDate, String departureTime) {
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
        System.out.println(departureTime);
//        System.out.println(departureDate);
//        this.departureDate = departureDate;

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
        this.departureDate = departureDate;
    }

    public String getAirplane() {
        return airplane;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice( float price ) {
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
