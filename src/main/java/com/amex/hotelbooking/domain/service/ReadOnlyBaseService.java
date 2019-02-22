package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.repository.HotelRepository;

/**
 * @author Nagaraja Settra
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private HotelRepository repository;

    public ReadOnlyBaseService(HotelRepository repository) {
        this.repository = repository;
    }
}
