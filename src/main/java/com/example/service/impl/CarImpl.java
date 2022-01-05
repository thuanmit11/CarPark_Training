package com.example.service.impl;

import com.example.dto.CarDTO;
import com.example.entities.Car;
import com.example.entities.Parkinglot;
import com.example.repository.CarRepo;
import com.example.repository.ParkinglotRepo;
import com.example.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {

    private final CarRepo carRepo;
    private final ParkinglotRepo parkinglotRepo;

    public CarImpl(CarRepo carRepo, ParkinglotRepo parkinglotRepo) {
        this.carRepo = carRepo;
        this.parkinglotRepo = parkinglotRepo;
    }

    @Override
    public Page<Car> getAll(Pageable pageable) {
        pageable = PageRequest.of(0,5);
        return carRepo.findAll(pageable);
    }

    @Override
    public List<CarDTO> getByParkinglot(Integer id) {
        return carRepo.findByParkinglot_ParkId(id);
    }

    @Override
    public List<CarDTO> getByParkinglotName(String name) {
        return carRepo.findByParkinglot_ParkName(name);
    }

    @Override
    public Car add(Car car, Parkinglot parkinglot) throws IllegalArgumentException{
        if(parkinglotRepo.findById(parkinglot.getParkId())==null){
            throw new IllegalArgumentException("parking lot ID not exist");
        }
        else {
            car.setParkinglot(parkinglot);
            return carRepo.save(car);
        }

    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return carRepo.findByLicensePlate(licensePlate);
    }
}
