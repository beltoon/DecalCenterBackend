package com.tobias.decalcenter.dtos;

public class CarDto {
    private Long id;
    private String carName;

public CarDto() {}

    public CarDto(Long id, String carName) {
        this.id = id;
        this.carName = carName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

}
