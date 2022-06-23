package com.tobias.decalcenter.dtos;

public class DecalInputDto {
    private String name;
    private String owner;
    private String car;
    private String event;

    public DecalInputDto(String name, String owner, String car, String event) {
        this.name = name;
        this.owner = owner;
        this.car = car;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getCar() {
        return car;
    }

    public String getEvent() {
        return event;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
