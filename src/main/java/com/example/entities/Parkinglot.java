package com.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Data
@Table(name = "parkinglot")
public class Parkinglot implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="parkId")
    private Integer parkId;

    @Column(name ="parkArea")
    private BigInteger parkArea;

    @Column(name ="parkName", length = 50)
    private String parkName;

    @Column(name ="parkPlace", length = 11)
    private String parkPlace;


    @Column(name ="parkPrice")
    private BigInteger parkPrice;

    @Column(name ="parkStatus", length = 50)
    private String parkStatus;

    @OneToMany(mappedBy = "parkinglot", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Car> cars;




}
