package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Decal;

import java.time.LocalDate;
import java.util.Set;

public class EventDto {
    private Long id;
    private String name;
    private Set<Decal> eventDecals;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public EventDto() {
    }

    public EventDto(Long id,
                    String name,
                    Set<Decal> eventDecals,
                    Boolean privateEvent,
                    LocalDate eventDate) {
        this.id = id;
        this.name = name;
        this.eventDecals = eventDecals;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDecals(Set<Decal> eventDecals) {
        this.eventDecals = eventDecals;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
