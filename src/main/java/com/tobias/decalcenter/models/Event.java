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
    private String availableCars;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public Event() {}

    public Event(Long id,
                 String name,
                 String availableCars,
                 Boolean privateEvent,
                 LocalDate eventDate) {
        this.id = id;
        this.name = name;
        this.availableCars = availableCars;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailableCars() {
        return availableCars;
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

    public void setAvailableCars(String availableCars) {
        this.availableCars = availableCars;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
