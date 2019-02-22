package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.model.entity.Booking;
import com.amex.hotelbooking.domain.model.entity.Hotel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author Nagaraja Settra
 */
public interface BookingService {

    /**
     *
     * @param booking
     * @return
     * @throws Exception
     */
    public void add(Booking booking) throws Exception;

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void update(Booking booking) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<Booking> findById(String id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Booking> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

}
