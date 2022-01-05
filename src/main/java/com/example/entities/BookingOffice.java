package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;


@Entity
@Data
@Table(name="bookingOffice")
public class BookingOffice implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officeId;

    private Date endContractDeadline;

    @Column(length = 50)
    private String officeName;

    @Column(length = 11)
    private String officePhone;

    @Column(length = 50)
    private String officePlace;

    private BigInteger officePrice;

    private Date startContractDeadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")

    private Trip trip;


}
