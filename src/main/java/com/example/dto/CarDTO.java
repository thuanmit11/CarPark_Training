package com.example.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CarDTO {

    private String licensePlate;

    private String carColor;

    private String carType;

    private String company;

    private String parkName;

    public CarDTO(String licensePlate, String carColor, String carType, String company, String parkName) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.parkName = parkName;
    }
}
