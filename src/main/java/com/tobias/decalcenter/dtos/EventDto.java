package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Decal;

import java.time.LocalDate;
import java.util.Set;

public class EventDto {
    private Long id;
    private String name;
    private Boolean privateEvent;
    private LocalDate eventDate;
    private Set<Decal> eventDecals;

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

    public Set<Decal> getEventDecals() {
        return eventDecals;
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

    public void setEventDecals(Set<Decal> eventDecals) {
        this.eventDecals = eventDecals;
    }
}
