package com.example.repository;

import com.example.entities.Ticket;
import com.example.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepo extends JpaRepository<Trip, Integer> {

    Trip findByTripId(Integer id);
}
