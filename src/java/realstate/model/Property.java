/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Mausam Rayamajhi
 */
@MappedSuperclass
public class Property extends BaseEntity{

    @Embedded
    Address address;
      
    @Column(length = 2000)
    private String description;
    
    @Column(nullable = false)
    private String type;
    private int bedroom;
    private int bathroom;


    public Property() {
    }

    public Property(Long id, String description, String type, int bedroom, int bathroom, Address address) {
        super(id);
        this.address =address;
        this.description = description;
        this.type = type;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   

   

}
