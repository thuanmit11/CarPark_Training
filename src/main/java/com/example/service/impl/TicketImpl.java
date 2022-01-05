package com.example.service.impl;

import com.example.dto.TicketDTO;
import com.example.dto.requestDTO.TicketRequestDTO;
import com.example.entities.Car;
import com.example.entities.Ticket;
import com.example.entities.Trip;
import com.example.repository.CarRepo;
import com.example.repository.TicketRepo;
import com.example.repository.TripRepo;
import com.example.service.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketImpl implements TicketService {

    private final TicketRepo ticketRepo;
    private final TripRepo tripRepo;
    private final CarRepo carRepo;

    public TicketImpl(TicketRepo ticketRepo, TripRepo tripRepo, CarRepo carRepo) {
        this.ticketRepo = ticketRepo;
        this.tripRepo = tripRepo;
        this.carRepo = carRepo;
    }


    @Override
    public List<TicketDTO> findAll() {
        return ticketRepo.findAllTicketDTO();
    }

    @Override
    public List<TicketDTO> findByTripID(Integer id) {
        return ticketRepo.findByTripId(id);
    }

    @Override
    public TicketDTO findByID(Integer id) {
        return ticketRepo.findByTicketId(id);
    }

    @Override
    public Ticket add(String string) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TicketRequestDTO ticket  = mapper.readValue(string, TicketRequestDTO.class);
        Ticket ticket1 = new Ticket();

        Trip tripId =  tripRepo.findByTripId(ticket.getTripId());

        if(tripId!=null) {
            ticket1.setTrip(tripId);

            Car licensePlate = carRepo.findByLicensePlate(ticket.getLicensePlate());

            ticket1.setBookingTime(ticket.getBookingTime());
            ticket1.setCustomerName(ticket.getCustomerName());
            ticket1.setCar(licensePlate);
            ticket1.setTrip(tripId);
            return ticketRepo.save(ticket1);
        }
        else{
            throw new IllegalArgumentException("Trip ID not exist");
        }
    }
}
