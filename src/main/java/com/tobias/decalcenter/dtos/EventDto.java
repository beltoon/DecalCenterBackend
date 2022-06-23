package com.tobias.decalcenter.dtos;

public class EventDto {
    private Long id;
    private String name;
    private String availableCars;
    private Boolean privateEvent;

    public EventDto() {}

    public EventDto(Long id, String name, String availableCars, Boolean privateEvent) {
        this.id = id;
        this.name = name;
        this.availableCars = availableCars;
        this.privateEvent = privateEvent;
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
}
