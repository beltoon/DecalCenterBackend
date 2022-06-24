package com.tobias.decalcenter.dtos;

public class DecalDto {
    private Long id;
    private String name;
    private String car;
    private String creator;
    private String company;
    private String series;

    public DecalDto() {
    }

    public DecalDto(Long id,
                    String name,
                    String car,
                    String creator,
                    String company,
                    String series) {
        this.id = id;
        this.name = name;
        this.car = car;
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

    public String getCar() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(String car) {
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