package com.example.dto.requestDTO;

import com.example.entities.Car;
import com.example.entities.Trip;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;
import java.util.Date;

public class TicketRequestDTO {

    private Integer ticketId;

    private Time bookingTime;

    private String customerName;

    private String licensePlate;

    private Integer tripId;

    public TicketRequestDTO(Integer ticketId, Time bookingTime, String customerName, String licensePlate, Integer tripId) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.licensePlate = licensePlate;
        this.tripId = tripId;
    }

    public TicketRequestDTO() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }
}
