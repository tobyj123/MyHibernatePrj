package com.mypackage.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by gis on 21.04.16.
 */
@Embeddable
public class Address {

    @Column(name = "STREET_°NAME")
    private String street;
    @Column(name = "CITY_NAME")
    private String city;
    private String state;
    private String pincode;


    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
