package com.tobias.decalcenter.dtos;

public class CarDto {
    private Long id;
    private String name;

public CarDto() {}

    public CarDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return name;
    }

    public void setName(String carName) {
        this.name = carName;
    }

}
