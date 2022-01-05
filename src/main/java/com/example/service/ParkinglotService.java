package com.example.service;


import com.example.entities.Parkinglot;

import java.util.List;

public interface ParkinglotService {

    List<Parkinglot> getAll();

    List<Parkinglot> searchByName(String name);

    String addParkinglot(Parkinglot parkinglot);


}
