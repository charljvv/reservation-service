package com.reservations.controller;

import com.reservations.helper.BookingTestHelper;
import com.reservations.model.Booking;
import com.reservations.service.BookingService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    @Test
    void saveBooking() {
        Booking booking = BookingTestHelper.getBooking();
        when(bookingService.saveBooking(booking)).thenReturn(booking);
        assertNotNull(bookingController.saveBooking(booking));
    }


    @Test
    void getAllBookings() {
        ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
        this.bookingController.getAllBookings(0, 3);
        verify(this.bookingService, times(1)).getPaginatedBookings(pageableArgumentCaptor.capture());
        assertEquals(3, pageableArgumentCaptor.getValue().getPageSize());
        assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    }

    @Test
    void getAllBookingsInDateRangePaginated() {
        ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
        ArgumentCaptor<LocalDate> startDateCaptor = ArgumentCaptor.forClass(LocalDate.class);
        ArgumentCaptor<LocalDate> endDateCaptor = ArgumentCaptor.forClass(LocalDate.class);
        this.bookingController.getAllBookingsInDateRangePaginated(0, 3, LocalDate.parse("2024-03-01"), LocalDate.parse("2024-03-03"));
        verify(this.bookingService, times(1)).getPaginatedBookingsBetweenStartAndEndDate(startDateCaptor.capture(), endDateCaptor.capture(), pageableArgumentCaptor.capture());
        assertEquals(3, pageableArgumentCaptor.getValue().getPageSize());
        assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
        assertNotNull(startDateCaptor.getValue());
        assertNotNull(endDateCaptor.getValue());
    }

}