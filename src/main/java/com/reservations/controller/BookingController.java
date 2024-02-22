package com.reservations.controller;

import com.reservations.model.Booking;
import com.reservations.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Slf4j  // Added in case  extra logging is necessary that's not covered by the debug log level set in application.properties
@Tag(name = "BookingController", description = "Manages Reservations/Bookings with some CRUD functions")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    @Operation(description = "Persists new bookings")
    public Booking saveBooking(@Valid @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/bookings/all")
    @Operation(description = "Retrieve all bookings as paginated content")
    public Page<Booking> getAllBookings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return bookingService.getPaginatedBookings(PageRequest.of(page, size));
    }


    @GetMapping("/bookings")
    @Operation(description = "Retrieve all bookings, filtered by start and end date, paginated")
    public Page<Booking> getAllBookingsInDateRangePaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        Pageable paging = PageRequest.of(page, size);
        return bookingService.getPaginatedBookingsBetweenStartAndEndDate(startDate, endDate, paging);
    }


    @PutMapping("/booking/{id}")
    @Operation(description = "Retrieve a booking by id")
    public Booking updateBooking(@RequestBody Booking booking,
                                 @PathVariable("id") Long id) {
        return bookingService.updateBooking(
                booking, id);
    }

    @DeleteMapping("/booking/{id}")
    @Operation(description = "Delete a booking by id")
    public String deleteBookingByID(@PathVariable("id")
                                    Long id) {
        bookingService.deleteBooking(
                id);
        return "Deleted Successfully";
    }

}
