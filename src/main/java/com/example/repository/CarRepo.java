package com.example.repository;

import com.example.dto.CarDTO;
import com.example.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepo extends JpaRepository<Car, String> {

    @Query("SELECT new com.example.dto.CarDTO(c.licensePlate, c.carColor, c.carType, c.company" +
            ", p.parkName ) FROM Car c INNER JOIN Parkinglot p ON c.parkinglot.parkId = p.parkId")
    Page<Car> findAll(Pageable pageable);


    @Query("SELECT new com.example.dto.CarDTO(c.licensePlate, c.carColor, c.carType, c.company" +
            ", p.parkName ) FROM Car c INNER JOIN Parkinglot p ON c.parkinglot.parkId = p.parkId" +
            " WHERE p.parkId = :id ")
    List<CarDTO> findByParkinglot_ParkId(@Param("id") Integer id);

    @Query(value = "SELECT new com.example.dto.CarDTO(c.licensePlate, c.carColor, c.carType, c.company" +
            ", p.parkName ) FROM Car c INNER JOIN Parkinglot p ON c.parkinglot.parkId = p.parkId" +
            " WHERE p.parkName LIKE  %:name%  ")
    List<CarDTO> findByParkinglot_ParkName(@Param("name") String name);

    Car findByLicensePlate(String licensePlate);
}
