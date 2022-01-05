package com.example.service;

import com.example.entities.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {



    List<Trip> findAll();

    Trip findByID(Integer id);

    Trip add(Trip trip);


}
