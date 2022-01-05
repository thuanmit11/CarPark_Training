package com.example.controller;

import com.example.dto.CarDTO;
import com.example.entities.Car;
import com.example.entities.Parkinglot;
import com.example.service.CarService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/findAll")
    public Page<Car> findAll(Pageable pageable){

        return carService.getAll(pageable);
    }

    @GetMapping("/findByParkinglotId/{id}")
    public List<CarDTO> findByParkinglotID(@PathVariable Integer id){
        return carService.getByParkinglot(id);
    }

    @GetMapping("/findByParkinglotName/")
    public List<CarDTO> findByParkinglotName(@RequestParam String name){
        return carService.getByParkinglotName(name);
    }

    @PostMapping("/add/{parkinglotID}")
    public Car add(@RequestBody Car car, @PathVariable Parkinglot parkinglotID){

        return carService.add(car,parkinglotID);
    }
}
