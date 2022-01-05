package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
import java.util.List;


@Entity
@Data
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name="ticketId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @Column(name="bookingTime")
    private Time bookingTime;

    @Column(name="customerName", length = 11)
    private String customerName;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "licensePlate", nullable = false, referencedColumnName = "licensePlate")
//    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripId", nullable = false, referencedColumnName = "tripId")
//    @JsonIgnore
    private Trip trip;

}
