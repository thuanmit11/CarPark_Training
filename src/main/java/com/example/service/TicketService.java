package com.example.service;

import com.example.dto.TicketDTO;
import com.example.entities.Car;
import com.example.entities.Ticket;
import com.example.entities.Trip;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface TicketService {

    List<TicketDTO> findAll();

    List<TicketDTO> findByTripID(Integer id);

    TicketDTO findByID(Integer id);

    Ticket add(String string) throws JsonProcessingException;

}
