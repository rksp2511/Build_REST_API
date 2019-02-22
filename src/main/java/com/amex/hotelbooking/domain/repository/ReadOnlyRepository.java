package com.amex.hotelbooking.domain.repository;

import com.amex.hotelbooking.domain.model.entity.Entity;

import java.util.Collection;

/**
 * @author Nagaraja Settra
 */
public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}
