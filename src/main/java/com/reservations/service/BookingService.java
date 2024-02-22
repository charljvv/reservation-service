package com.reservations.service;

import com.reservations.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    Booking saveBooking(Booking booking);

    List<Booking> getBookings();

    Page<Booking> getPaginatedBookings(Pageable pageable);

    Page<Booking> getPaginatedBookingsBetweenStartAndEndDate(LocalDate startDate, LocalDate endDate, Pageable pageable);


    Booking updateBooking(Booking booking, Long id);

    void deleteBooking(Long id);
}
