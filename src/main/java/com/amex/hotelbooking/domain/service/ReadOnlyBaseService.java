package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.repository.HotelRepository;

/**
 * @author Nagaraja Settra
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private HotelRepository<TE, T> repository;

    public ReadOnlyBaseService(HotelRepository<TE, T> repository) {
        this.repository = repository;
    }
}
