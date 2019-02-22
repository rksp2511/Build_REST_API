package com.amex.hotelbooking.domain.repository;

import com.amex.hotelbooking.domain.model.entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Nagaraja Settra
 */
@Repository
public interface HotelRepository extends CrudRepository<Hotel, String> {

    Collection<Hotel> findByName(String name);

}
