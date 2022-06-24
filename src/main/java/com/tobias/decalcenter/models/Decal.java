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
    private String creator;
    private String company;
    private String series;

    public Decal() {}

    public Decal(Long id,
                 String name,
                 String car,
                 String creator,
                 String company,
                 String series) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.creator = creator;
        this.company = company;
        this.series = series;
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

    public String getCreator() {
        return creator;
    }

    public String getCompany() {
        return company;
    }

    public String getSeries() {
        return series;
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

    public void setCreator(String owner) {
        this.creator = owner;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSeries(String event) {
        this.series = event;
    }
}
