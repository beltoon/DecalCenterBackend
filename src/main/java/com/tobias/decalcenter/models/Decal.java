package com.tobias.decalcenter.models;

import javax.persistence.*;

@Entity
@Table(name = "decals")
public class Decal {

    @Id
    @GeneratedValue
    Long id;

    private String name;
    private String car;
    private String owner;
    private String brand;
    private String event;

    public Decal() {}

    public Decal(Long id,
                 String name,
                 String car,
                 String owner,
                 String brand,
                 String event) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.owner = owner;
        this.brand = brand;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCar() {
        return car;
    }

    public String getOwner() {
        return owner;
    }

    public String getBrand() {
        return brand;
    }

    public String getEvent() {
        return event;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
