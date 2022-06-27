package com.tobias.decalcenter.dtos;

import java.time.LocalDate;

public class EventInputDto {
    private String name;
    private String availableDecals;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public EventInputDto(String name,
                         String availableDecals,
                         Boolean privateEvent,
                         LocalDate eventDate) {
        this.name = name;
        this.availableDecals = availableDecals;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableDecals(String availableDecals) {
        this.availableDecals = availableDecals;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
