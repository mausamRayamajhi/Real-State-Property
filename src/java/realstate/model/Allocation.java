/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realstate.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mausam Rayamajhi
 */
@Entity
@Table(name = "Allocation")
@NamedQueries({
    @NamedQuery(name = "findAllAllocation", query = "SELECT m FROM Allocation m")
    ,
      @NamedQuery(name = "findByManagerId", query = "SELECT m FROM Allocation m where m.manager.id =:id"),})

public class Allocation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "rent_Property_id", nullable = true)
    private RentProperty rentProperty;

    @ManyToOne
    @JoinColumn(name = "sale_Property_id", nullable = true)
    private SaleProperty saleProperty;

    private LocalDateTime date;

    public Allocation() {
    }

    public Allocation(Long id, Manager manager, RentProperty rentProperty, SaleProperty saleProperty, LocalDateTime date) {
        super(id);
        this.manager = manager;
        this.rentProperty = rentProperty;
        this.saleProperty = saleProperty;
        this.date = date;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public RentProperty getRentProperty() {
        return rentProperty;
    }

    public void setRentProperty(RentProperty rentProperty) {
        this.rentProperty = rentProperty;
    }

    public SaleProperty getSaleProperty() {
        return saleProperty;
    }

    public void setSaleProperty(SaleProperty saleProperty) {
        this.saleProperty = saleProperty;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Allocation{" + "manager=" + manager + ", rentProperty=" + rentProperty + ", saleProperty=" + saleProperty + ", date=" + date + '}';
    }

}
