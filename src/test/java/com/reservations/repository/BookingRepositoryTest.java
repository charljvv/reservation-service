package com.reservations.repository;

import com.reservations.helper.BookingTestHelper;
import com.reservations.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This would be a good place to test integration
 * against a real DB like postgres or mysql, instead of H2
 * That can be achieved by adding a dependency on Testcontainers here and instantiating a test container with postgres details.
 * A bit overkill for this assignment though, but worth nothing.
 * This test will validate Data being inserted and queried against the H2 in-mem db instead.
 */
@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    private Booking testBooking;

    @BeforeEach
    void setUp() {

        testBooking = BookingTestHelper.getBooking();
        bookingRepository.save(testBooking);
    }

    @Test
    void findBookingsByStartDateIsGreaterThanEqualAndEndDateLessThanEqual() {
        Page<Booking> bookingFromRepo = bookingRepository.findBookingsByStartDateIsGreaterThanEqualAndEndDateLessThanEqual(testBooking.getStartDate(), testBooking.getEndDate(), PageRequest.of(0, 10));
        assertNotNull(bookingFromRepo);
        assertEquals(1, bookingFromRepo.get().toList().size());
        assertEquals(bookingFromRepo.get().findFirst().get(), testBooking);
    }

}