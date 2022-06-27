package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Car;

public class DecalInputDto {
    private String name;
    private Car car;
    private String creator;
    private String company;
    private String series;

    public DecalInputDto(String name,
                         Car car,
                         String creator,
                         String company,
                         String series) {
        this.name = name;
        this.car = car;
        this.creator = creator;
        this.company = company;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
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
