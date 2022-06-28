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
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "decal_id")
    private Set<Decal> addEventDecals = new HashSet<>();

    private String name;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public Event() {
    }

    public Event(Long id, Set<Decal> decals, String name, Boolean privateEvent, LocalDate eventDate) {
        this.id = id;
        this.addEventDecals = addEventDecals;
        this.name = name;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public Set<Decal> getAddEventDecals() {
        return addEventDecals;
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

    public void setAddEventDecals(Set<Decal> decals) {
        this.addEventDecals = addEventDecals;
    }

    public void eventDecals(Decal decal) {
        addEventDecals.add(decal);
    }
}
