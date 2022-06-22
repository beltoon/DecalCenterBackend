package com.tobias.decalcenter.models;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    Long id;
    private String name;

    public Car() {}

    public Car(Long id,
               String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
