/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mausam Rayamajhi
 */
@Entity
@Table(name = "property_manager")
public class Manager extends BaseEntity {
    private String firstName;
    private String lastName;
    private int phone;
    private int mobile;
    private String email;
    
     @OneToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "Rent_Property_Allocation")
     private List<RentProperty> rentPropertys;
     
     @OneToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "Sales_Property_Allocation")
     private List<SaleProperty> salePropertys;


   

    public Manager() {
    }

    public Manager(String firstName, String lastName, int phone, int mobile, String email, Long id ,RentProperty rentalProperty) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
      
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manager{" + "firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", mobile=" + mobile + ", email=" + email + '}';
    }
    
    
    
    
}
