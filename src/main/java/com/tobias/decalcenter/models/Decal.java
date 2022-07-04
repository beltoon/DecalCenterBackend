package com.tobias.decalcenter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "eventDecals")
    private Set<Event> events = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    private String decalPosition;
    private String creator;
    private String company;
    private String series;

    @OneToOne
    @JoinColumn(name = "file_name")
    FileUploadResponse file;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Car getCar() {
        return car;
    }

    public String getDecalPosition() {
        return decalPosition;
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

    public FileUploadResponse getFile() {
        return file;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDecalPosition(String decalPosition) {
        this.decalPosition = decalPosition;
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

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }
}
