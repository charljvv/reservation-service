package com.reservations.helper;

import com.reservations.model.Booking;
import com.reservations.model.ContactDetails;
import com.reservations.model.PersonalDetails;
import com.reservations.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDBHelper {

    /**
     * Used for test injection of a few reservations to simulate the REST API's behaviour
     *
     * @param repository - the injected repository service to persist
     * @return {@link CommandLineRunner} ran at Startup of the ReservationsApplication
     */
    @Bean
    CommandLineRunner initDatabase(BookingRepository repository) {
        return args -> {

            log.info("Adding Booking " + repository.save(Booking.builder()
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusDays(2))
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
                                    .build()).build()));

            log.info("Adding Booking " + repository.save(Booking.builder()
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusDays(2))
                    .contactDetails(
                            ContactDetails.builder()
                                    .cellNumber("07201011111")
                                    .workNumber("01212312311")
                                    .email("test@testing.com")
                                    .build())
                    .personalDetails(
                            PersonalDetails.builder()
                                    .firstName("Test")
                                    .surname("Surname")
                                    .build()).build()));
        };
    }
}
