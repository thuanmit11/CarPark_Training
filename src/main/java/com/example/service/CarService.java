package com.example.service;

import com.example.dto.CarDTO;
import com.example.entities.Car;
import com.example.entities.Parkinglot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    Page<Car> getAll(Pageable pageable);

    List<CarDTO> getByParkinglot(Integer id);


    List<CarDTO> getByParkinglotName(String name);

    Car add(Car car, Parkinglot parkinglot);

    Car findByLicensePlate(String licensePlate);



}
