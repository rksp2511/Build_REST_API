package com.amex.hotelbooking.domain.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * @author Nagaraja Settra
 */
public interface HotelRepository<Hotel, String> extends CrudRepository<Hotel, String> {
//    public interface HotelRepository<Hotel, String> extends Repository<Hotel, String> {

    boolean containsName(String name);

    public Collection<Hotel> findByName(String name) throws Exception;
}
