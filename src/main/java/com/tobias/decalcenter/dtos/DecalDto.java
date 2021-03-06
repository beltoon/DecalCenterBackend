package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Car;
import com.tobias.decalcenter.models.FileUploadResponse;

public class DecalDto {
    private Long id;
    private String name;
    private String decalPosition;
    private Car car;
    private String company;
    private String series;

    private FileUploadResponse fileName;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public FileUploadResponse getFileName() {
        return fileName;
    }

    public String getDecalPosition() {
        return decalPosition;
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

    public void setFileName(FileUploadResponse fileName) {
        this.fileName = fileName;
    }

    public void setDecalPosition(String decalPosition) {
        this.decalPosition = decalPosition;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}