package com.example.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table(name ="car")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "licensePlate", length = 50)
    private String licensePlate;

    @Column(name ="carColor", length = 11)
    private String carColor;

    @Column(name ="carType", length = 50)
    private String carType;

    @Column(name ="company", length = 50)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parkId", referencedColumnName = "parkId")
    @Autowired
    private Parkinglot parkinglot;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;




}
