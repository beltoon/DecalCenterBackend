package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Decal;

import java.time.LocalDate;
import java.util.Set;

public class EventInputDto {
    private String name;
    private Set<Decal> decals;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public EventInputDto(String name,
                         Set<Decal> decals,
                         Boolean privateEvent,
                         LocalDate eventDate) {
        this.name = name;
        this.decals = decals;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public Set<Decal> getDecals() {
        return decals;
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

    public void setDecals(Set decals) {
        this.decals = decals;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
