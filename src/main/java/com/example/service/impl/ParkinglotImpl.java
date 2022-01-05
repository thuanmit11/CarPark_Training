package com.example.service.impl;

import com.example.entities.Parkinglot;
import com.example.repository.ParkinglotRepo;
import com.example.service.ParkinglotService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParkinglotImpl implements ParkinglotService {

    private final ParkinglotRepo parkinglotRepo;

    public ParkinglotImpl(ParkinglotRepo parkinglotRepo) {
        this.parkinglotRepo = parkinglotRepo;
    }

    @Override
    public List<Parkinglot> getAll() {
        return parkinglotRepo.findAll();
    }

    @Override
    public List<Parkinglot> searchByName(String name) {
        return parkinglotRepo.findByParkNameContains(name);
    }

    @Override
    public String addParkinglot(Parkinglot parkinglot) {
        parkinglotRepo.save(parkinglot);
        return parkinglot.toString();
    }
}
