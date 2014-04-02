package com.titan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cruise implements Serializable {

    private static final long serialVersionUID = -4364984086225906605L;

    private int id;
    private String name;
    private Ship ship;
    private Collection<Reservation> reservations = new ArrayList<Reservation>();

    public Cruise() {
    }

    public Cruise(String name, Ship ship) {
        super();
        this.name = name;
        this.ship = ship;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "ship_id")
    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @OneToMany(mappedBy = "cruise")
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
