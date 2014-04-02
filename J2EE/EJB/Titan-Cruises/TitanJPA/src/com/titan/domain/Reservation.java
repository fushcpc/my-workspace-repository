package com.titan.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 8773284608463733272L;

    private int id;
    private double amountPaid;
    private Date date;
    private Cruise cruise;
    private Set<Customer> customers = new HashSet<Customer>();
    private Set<Cabin> cabins = new HashSet<Cabin>();

    public Reservation() {

    }

    public Reservation(Customer customer, Cruise cruise, Cabin cabin, double price, Date dateBooked) {
        setAmountPaid(price);
        setDate(dateBooked);
        setCruise(cruise);

        Set<Cabin> cabins = new HashSet<Cabin>();
        cabins.add(cabin);
        setCabins(cabins);

        Set<Customer> customers = new HashSet<Customer>();
        customers.add(customer);
        setCustomers(customers);
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "amount_paid")
    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Column(name = "date_reserved")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "cruise_id")
    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    @ManyToMany
    @JoinTable(name = "reservation_customer", joinColumns = { @JoinColumn(name = "reservation_id") }, inverseJoinColumns = { @JoinColumn(name = "customer_id") })
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @ManyToMany
    @JoinTable(name = "cabin_reservation", joinColumns = { @JoinColumn(name = "reservation_id") }, inverseJoinColumns = { @JoinColumn(name = "cabin_id") })
    public Set<Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(Set<Cabin> cabins) {
        this.cabins = cabins;
    }
}
