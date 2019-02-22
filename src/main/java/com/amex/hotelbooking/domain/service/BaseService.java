package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.repository.HotelRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Nagaraja Settra
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private HotelRepository<TE, T> _repository;

    public BaseService(HotelRepository<TE, T> repository) {
        super(repository);
        this._repository = repository;
    }

    public void add(TE entity) throws Exception {
        _repository.save(entity);
    }

    public Collection<TE> getAll() {
        List<TE> allItems = new ArrayList<>();
        _repository.findAll().forEach(allItems::add);
        return allItems;
    }
}
