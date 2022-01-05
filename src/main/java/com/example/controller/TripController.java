package com.example.controller;

import com.example.entities.Trip;
import com.example.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/findAll")
    public List<Trip> findAll(){
        return tripService.findAll();
    }

    @GetMapping("findByID/{id}")
    public Trip findByID(@PathVariable Integer id){
        return tripService.findByID(id);
    }

    @PostMapping("/add")
    public Trip add (@RequestBody Trip trip){
        return tripService.add(trip);
    }
}
