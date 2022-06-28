package com.tobias.decalcenter.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    Long id;

    @ManyToMany(mappedBy = "eventDecals")
    public Set<Decal> decals = new HashSet<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "car")
//    private Set<Decal> availableDecals = new HashSet<>();

    private String name;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public Event() {}

    public Event(Long id, Set<Decal> decals, String name, Boolean privateEvent, LocalDate eventDate) {
        this.id = id;
        this.decals = decals;
        this.name = name;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

//    public Event(Long id,
//                 String name,
//                 String availableDecals,
//                 Boolean privateEvent,
//                 LocalDate eventDate) {
//        this.id = id;
//        this.name = name;
//        this.availableDecals = availableDecals;
//        this.privateEvent = privateEvent;
//        this.eventDate = eventDate;
//    }


    public Set<Decal> getDecals() {
        return decals;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getPrivateEvent() {
        return privateEvent;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setDecals(Set<Decal> decals) {
        this.decals = decals;
    }
}
