package com.amex.hotelbooking.domain.repository;

import com.amex.hotelbooking.domain.model.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Nagaraja Settra
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, String> {
    Collection<Booking> findByName(String name);
}
