package com.example.repository;

import com.example.entities.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingOfficeRepo extends JpaRepository<BookingOffice, Integer> {

    BookingOffice findByOfficeId(Integer id);

    List<BookingOffice> findAll();

    List<BookingOffice> findBookingOfficeByOfficeName(String name);

    void deleteByOfficeId(Integer id);


}
