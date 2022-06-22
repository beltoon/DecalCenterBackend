package com.tobias.decalcenter.dtos;

public class CarInputDto {

    private String carName;

    public CarInputDto(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
