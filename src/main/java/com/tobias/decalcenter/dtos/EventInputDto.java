package com.tobias.decalcenter.dtos;

import java.time.LocalDate;

public class EventInputDto {
    private String name;
    private String availableCars;
    private Boolean privateEvent;
    private LocalDate eventDate;

    public EventInputDto(String name,
                         String availableCars,
                         Boolean privateEvent,
                         LocalDate eventDate) {
        this.name = name;
        this.availableCars = availableCars;
        this.privateEvent = privateEvent;
        this.eventDate = eventDate;
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
