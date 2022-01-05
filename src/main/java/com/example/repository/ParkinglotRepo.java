package com.example.repository;

import com.example.entities.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkinglotRepo extends JpaRepository<Parkinglot, Integer> {


    List<Parkinglot> findByParkNameContains(String name);

    Parkinglot findByParkId(Integer id);
}
