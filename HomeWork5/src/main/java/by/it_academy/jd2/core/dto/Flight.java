package by.it_academy.jd2.core.dto;

import javax.persistence.*;


@Entity(name = "flights")
@Table(name = "flights")
public class Flight {

    @Id
    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "scheduled_departure", columnDefinition = "timestamptz")
    private String departureDate;

    @Column(name = "departure_airport",columnDefinition = "bpchar(3)", nullable = false)
    private String departureAirport;

    @Column(name = "scheduled_arrival", columnDefinition = "timestamptz")
    private String arrivalDate;

    @Column(name = "arrival_airport", columnDefinition = "bpchar(3)", nullable = false)
    private String arrivalAirport;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

}
