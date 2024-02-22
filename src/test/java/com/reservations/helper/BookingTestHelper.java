package com.reservations.helper;

import com.reservations.model.Booking;
import com.reservations.model.ContactDetails;
import com.reservations.model.PersonalDetails;

import java.time.LocalDate;

/**
 * Helper to instantiate some common objects used in multiple tests
 */
public class BookingTestHelper {
    public static Booking getBooking() {
        Booking booking = Booking.builder()
                .startDate(LocalDate.parse("2024-03-01"))
                .endDate(LocalDate.parse("2024-03-03"))
                .contactDetails(
                        ContactDetails.builder()
                                .cellNumber("083123412345")
                                .workNumber("012341231221")
                                .email("test@test.com")
                                .build())
                .personalDetails(
                        PersonalDetails.builder()
                                .firstName("Charl")
                                .surname("JVV")
                                .build()).build();
        return booking;
    }
}
