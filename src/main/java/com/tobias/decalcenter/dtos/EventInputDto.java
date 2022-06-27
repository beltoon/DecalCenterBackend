package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Decal;

import java.time.LocalDate;
import java.util.Set;

public class EventInputDto {
    private String name;
    private Set<Decal> eventDecals;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public EventInputDto(String name,
                         Set<Decal> eventDecals,
                         Boolean privateEvent,
                         LocalDate eventDate) {
        this.name = name;
        this.eventDecals = eventDecals;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public Set<Decal> getEventDecals() {
        return eventDecals;
    }

    public Boolean getPrivateEvent() {
        return privateEvent;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDecals(Set eventDecals) {
        this.eventDecals = eventDecals;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
