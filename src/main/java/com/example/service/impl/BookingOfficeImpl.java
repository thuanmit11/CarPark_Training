package com.example.service.impl;

import com.example.entities.BookingOffice;
import com.example.entities.BookingOfficeRequestDTO;
import com.example.entities.Trip;
import com.example.repository.BookingOfficeRepo;
import com.example.repository.TripRepo;
import com.example.service.BookingOfficeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingOfficeImpl implements BookingOfficeService {

    private final BookingOfficeRepo bookingOfficeRepo;
    private final TripRepo tripRepo;

    public BookingOfficeImpl(BookingOfficeRepo bookingOfficeRepo, TripRepo tripRepo) {
        this.bookingOfficeRepo = bookingOfficeRepo;
        this.tripRepo = tripRepo;
    }


    @Override
    public List<BookingOffice> getAll() {
        return bookingOfficeRepo.findAll();
    }

    @Override
    public Optional<BookingOffice> getBookingOfficeById(Integer id) {
        return bookingOfficeRepo.findById(id);
    }

    @Override
    public List<BookingOffice> getBookingOfficeByName(String name) {
        return bookingOfficeRepo.findBookingOfficeByOfficeName(name);
    }

    @Override
    public BookingOffice addBookingOffice(String string) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BookingOfficeRequestDTO bookingOfficeRequestDTO = objectMapper.readValue(string, BookingOfficeRequestDTO.class);

        Trip trip = tripRepo.findByTripId(bookingOfficeRequestDTO.getTripId());

        if (trip != null) {
            BookingOffice bookingOffice = new BookingOffice();
            bookingOffice.setTrip(trip);
            bookingOffice.setStartContractDeadline(bookingOfficeRequestDTO.getStartContractDeadline());
            bookingOffice.setOfficeId(bookingOfficeRequestDTO.getOfficeId());
            bookingOffice.setOfficePlace(bookingOfficeRequestDTO.getOfficePlace());
            bookingOffice.setOfficePhone(bookingOfficeRequestDTO.getOfficePhone());
            bookingOffice.setEndContractDeadline(bookingOfficeRequestDTO.getEndContractDeadline());
            bookingOffice.setOfficePrice(bookingOfficeRequestDTO.getOfficePrice());
            bookingOffice.setOfficeName(bookingOfficeRequestDTO.getOfficeName());


            return bookingOfficeRepo.save(bookingOffice);

        }
        else{
            throw new IllegalArgumentException("Trip id not exist");
        }
    }

    @Override
    public void deleteById(Integer id) {
        bookingOfficeRepo.deleteByOfficeId(id);
    }
}
