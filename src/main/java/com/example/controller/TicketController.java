package com.example.controller;

import com.example.dto.requestDTO.TicketRequestDTO;
import com.example.dto.TicketDTO;
import com.example.entities.Car;
import com.example.entities.Ticket;
import com.example.entities.Trip;
import com.example.service.CarService;
import com.example.service.TicketService;
import com.example.service.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TripService tripService;
    private final CarService carService;

    public TicketController(TicketService ticketService, TripService tripService, CarService carService) {
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.carService = carService;
    }


    @GetMapping("/findAll")
    public List<TicketDTO> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("/findByTripID/{id}")
    public List<TicketDTO> findByTripID(@PathVariable Integer id){
        return ticketService.findByTripID(id);
    }

    @GetMapping("/findByID/{id}")
    public TicketDTO findByID(@PathVariable Integer id){
        return ticketService.findByID(id);
    }

    @PostMapping("/add")
    public Ticket add(@RequestBody String string) throws JsonProcessingException {

        return ticketService.add(string);
    }
}
