package by.it_academy.jd2.core.dto;

import javax.persistence.*;

@Entity
@Table(name = "airports_data", schema = "bookings")
public class Air {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_code",unique = true, columnDefinition = "bpchar(3)", nullable = false, length = 3)
    private String airport_code;


    @Column(columnDefinition = "jsonb", nullable = false)
    private String airport_name;
    @Column(columnDefinition = "jsonb")
    private String city;

    @Column(columnDefinition = "point")
    private String coordinates;

    @Column(columnDefinition = "point")
    private String timezone;

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
