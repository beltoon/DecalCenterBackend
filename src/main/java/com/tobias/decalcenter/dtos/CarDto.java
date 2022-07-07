package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Decal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

public class CarDto {
    private Long id;
    private String name;
    private String brand;
    private String type;
    private String category;
    private Set<Decal> decals;

    public Set<Decal> getDecals() {
        return decals;
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

    public void setDecals(Set<Decal> decals) {
        this.decals = decals;
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
