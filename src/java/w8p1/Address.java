/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8p1;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Mausam Rayamajhi
 */
@MappedSuperclass
public class Address {
    private int streetNumber;
    private String streetName;
    private String city;
    private int postCode;
    private String country;

    public Address() {
    }

    
    public Address(int streetNumber, String streetName, String city, int postCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postCode=" + postCode + ", country=" + country + '}';
    }
    
    
    
}
