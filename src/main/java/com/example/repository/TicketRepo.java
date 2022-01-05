package com.example.repository;

import com.example.dto.TicketDTO;
import com.example.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    @Query(value="SELECT new com.example.dto.TicketDTO (t.ticketId, t.bookingTime, t.customerName, " +
            "c.licensePlate, tr.tripId ) FROM Ticket t INNER JOIN Car c " +
            "ON c.licensePlate = t.car.licensePlate INNER JOIN Trip tr ON tr.tripId = t.trip.tripId" +
            " WHERE tr.tripId= :id")
    List<TicketDTO> findByTripId(@Param("id") Integer id);

    @Query(value="SELECT new com.example.dto.TicketDTO (t.ticketId, t.bookingTime, t.customerName, " +
            "c.licensePlate, tr.tripId ) FROM Ticket t INNER JOIN Car c " +
            "ON c.licensePlate = t.car.licensePlate INNER JOIN Trip tr ON tr.tripId = t.trip.tripId" +
            " WHERE t.ticketId = ?1")
    TicketDTO findByTicketId(Integer id);


    @Query(value="SELECT new com.example.dto.TicketDTO (t.ticketId, t.bookingTime, t.customerName, " +
            "c.licensePlate, tr.tripId ) FROM Ticket t INNER JOIN Car c " +
            "ON c.licensePlate = t.car.licensePlate INNER JOIN Trip tr ON tr.tripId = t.trip.tripId")
    List<TicketDTO> findAllTicketDTO();


}
