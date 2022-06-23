package com.tobias.decalcenter.dtos;

public class DecalInputDto {
    private String name;
    private String car;
    private String owner;
    private String brand;
    private String event;

    public DecalInputDto(String name,
                         String car,
                         String owner,
                         String brand,
                         String event) {
        this.name = name;
        this.car = car;
        this.owner = owner;
        this.brand = brand;
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public String getCar() {
        return car;
    }

    public String getOwner() {
        return owner;
    }

    public String getBrand() {
        return brand;
    }

    public String getEvent() {
        return event;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
