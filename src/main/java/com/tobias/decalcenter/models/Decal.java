package com.tobias.decalcenter.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "decals")
public class Decal {

    @Id
    @GeneratedValue
    Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "event_decals",
            joinColumns = @JoinColumn(name = "decal_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Decal> eventDecals = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
    private String creator;
    private String company;
    private String series;

    public Decal() {
    }

    public Decal(Long id,
                 String name,
                 Car car,
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

    public Car getCar() {
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

    public void setCar(Car car) {
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


//    public void eventDecals(Decal decal) {
//        eventDecals.add(decal);
//    }
}
