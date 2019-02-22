package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.model.entity.Hotel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author Nagaraja Settra
 */
public interface HotelService {

    /**
     *
     * @param hotel
     * @throws Exception
     */
    public void add(Hotel hotel) throws Exception;

    /**
     *
     * @param hotel
     * @throws Exception
     */
    public void update(Hotel hotel) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param hotelId
     * @return
     * @throws Exception
     */
    public Optional<Hotel> findById(String hotelId) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Hotel> findByName(String name) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public Collection<Hotel> findAll() throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Hotel> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

}
