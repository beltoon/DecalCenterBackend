package com.tobias.decalcenter.dtos;

import com.tobias.decalcenter.models.Car;
import com.tobias.decalcenter.models.FileUploadResponse;

public class DecalInputDto {
    private String name;
    private Car car;
    private String decalPosition;
    private String creator;
    private String company;
    private String series;
    FileUploadResponse file;

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

    public FileUploadResponse getFile() {
        return file;
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

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }
}
