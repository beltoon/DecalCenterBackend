package com.tobias.decalcenter.dtos;

public class EventInputDto {
    private String name;
    private String availableCars;
    private Boolean privateEvent;

    public EventInputDto(String name, String date, Boolean activeAfterDate, String availableCars, Boolean privateEvent) {
        this.name = name;
        this.availableCars = availableCars;
        this.privateEvent = privateEvent;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableCars(String availableCars) {
        this.availableCars = availableCars;
    }

    public void setPrivateEvent(Boolean privateEvent) {
        this.privateEvent = privateEvent;
    }
}
