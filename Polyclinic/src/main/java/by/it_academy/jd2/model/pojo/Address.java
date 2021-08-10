package by.it_academy.jd2.model.pojo;

import by.it_academy.jd2.model.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;


public class Address implements Serializable{

    @JsonView(Views.Public.class)
    private String street;

    @JsonView(Views.Public.class)
    private String city;

    @JsonView(Views.Public.class)
    private String country;

    @JsonView(Views.Public.class)
    private int zipCode;

    public Address() {
    }

    public Address(String street, String city, String country, int zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

}
