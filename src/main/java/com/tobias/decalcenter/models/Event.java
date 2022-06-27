package com.tobias.decalcenter.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    Long id;

    private String name;
    private String availableDecals;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public Event() {}

    public Event(Long id,
                 String name,
                 String availableDecals,
                 Boolean privateEvent,
                 LocalDate eventDate) {
        this.id = id;
        this.name = name;
        this.availableDecals = availableDecals;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailableDecals() {
        return availableDecals;
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

    public void setAvailableDecals(String availableCars) {
        this.availableDecals = availableCars;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
