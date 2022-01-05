package com.example.service.impl;

import com.example.entities.Trip;
import com.example.repository.TripRepo;
import com.example.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TripImpl implements TripService {

    private final TripRepo tripRepo;

    public TripImpl(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }


    @Override
    public List<Trip> findAll() {
        return tripRepo.findAll();
    }

    @Override
    public Trip findByID(Integer id) {
        return tripRepo.findByTripId(id);
    }

    @Override
    public Trip add(Trip trip) {
        return tripRepo.save(trip);
    }
}
