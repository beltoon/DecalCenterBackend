package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Car;

public class DecalDto {
    private Long id;
    private String name;
    private String decalPosition;
    private Car car;
    private String creator;
    private String company;
    private String series;

    public DecalDto() {
    }

    public DecalDto(Long id,
                    String name,
                    Car car,
                    String decalPosition,
                    String creator,
                    String company,
                    String series) {
        this.id = id;
        this.name = name;
        this.car = car;
        this.decalPosition = decalPosition;
        this.creator = creator;
        this.company = company;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public String getDecalPosition() {
        return decalPosition;
    }

    public String getCreator() {
        return creator;
    }

    public String getCompany() {
        return company;
    }

    public String getSeries() {
        return series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDecalPosition(String decalPosition) {
        this.decalPosition = decalPosition;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}