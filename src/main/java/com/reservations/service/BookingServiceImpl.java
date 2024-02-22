package com.reservations.service;

import com.reservations.model.Booking;
import com.reservations.repository.BookingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        /*
            This would be a good place to call a Room Validation Engine to query for available rooms and their availability
            before finalizing the booking.
         */
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookings() {
        return StreamSupport
                .stream(bookingRepository.findAll().spliterator(), false)
                .toList();
    }

    public Page<Booking> getPaginatedBookings(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }


    public Page<Booking> getPaginatedBookingsBetweenStartAndEndDate(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return bookingRepository.findBookingsByStartDateIsGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate, pageable);
    }

    public Booking updateBooking(Booking booking, Long id) {
        if (bookingRepository.findById(id).isPresent()) {
            return bookingRepository.save(booking);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
