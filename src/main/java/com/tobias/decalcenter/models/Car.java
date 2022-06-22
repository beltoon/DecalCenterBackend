package com.tobias.decalcenter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    Long id;

    private String carName;

    public Car() {}

    public Car(Long id,
               String carName) {
        this.id = id;
        this.carName = carName;
    }

    public Long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarName(String name) {
        this.carName = name;
    }
}
