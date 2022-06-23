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
    private String event;

    public Decal() {}

    public Decal(Long id, String name, String owner, String car, String event) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.owner = owner;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getCar() {
        return car;
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
