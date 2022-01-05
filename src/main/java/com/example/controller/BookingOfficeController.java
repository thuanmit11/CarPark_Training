package com.example.controller;

import com.example.entities.BookingOffice;
import com.example.entities.BookingOfficeRequestDTO;
import com.example.entities.Trip;
import com.example.service.BookingOfficeService;
import com.example.service.TripService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookingOffice")
public class BookingOfficeController {

    private final BookingOfficeService bookingOfficeService;
    private final TripService tripService;


    public BookingOfficeController(BookingOfficeService bookingOfficeService, TripService tripService) {
        this.bookingOfficeService = bookingOfficeService;
        this.tripService = tripService;
    }


    @GetMapping("/findAll")
    public List<BookingOffice> getAll(){
        return bookingOfficeService.getAll();
    }

    @PostMapping("/add")
    public BookingOffice add(@RequestBody String string) throws JsonProcessingException {

        return bookingOfficeService.addBookingOffice(string);
    }

    @GetMapping("/findByID/{id}")
    public Optional<BookingOffice> getByID(@PathVariable Integer id){
        return bookingOfficeService.getBookingOfficeById(id);
    }
}
