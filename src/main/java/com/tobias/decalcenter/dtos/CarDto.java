package com.tobias.decalcenter.dtos;

public class CarDto {
    private Long id;
    private String name;
    private String brand;
    private String type;
    private String category;


public CarDto() {}

    public CarDto(Long id,
                  String name,
                  String brand,
                  String type,
                  String category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
