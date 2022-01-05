package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;


@Data
public class BookingOfficeRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer officeId;

    private Date endContractDeadline;

    private String officeName;

    private String officePhone;

    private String officePlace;

    private BigInteger officePrice;

    private Date startContractDeadline;

    private Integer tripId;

}
