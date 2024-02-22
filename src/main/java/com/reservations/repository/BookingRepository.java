package com.reservations.repository;

import com.reservations.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long>, CrudRepository<Booking, Long> {

    /**
     * An example of a custom query to filter on specific columns
     * @param startDate
     * @param endDate
     * @param page
     * @return
     */
    Page<Booking> findBookingsByStartDateIsGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate, Pageable page);
}
