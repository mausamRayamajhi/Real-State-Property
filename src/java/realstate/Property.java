/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate;

import javax.persistence.MappedSuperclass;

/**
 *
 * @author Mausam Rayamajhi
 */
@MappedSuperclass
public class Property extends BaseEntity{

    private Address address;
    private String description;
    private String type;
    private int bedroom;
    private int bathroom;


    public Property() {
    }

    public Property(Long id,Address address, String description, String type, int bedroom, int bathroom) {
        super(id);
        this.address = address;
        this.description = description;
        this.type = type;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public String toString() {
        return "Property{" + "address=" + address + ", description=" + description + ", type=" + type + ", bedroom=" + bedroom + ", bathroom=" + bathroom + '}';
    }

   

}
