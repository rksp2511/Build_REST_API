package com.amex.hotelbooking.domain.model.entity;

/**
 *
 * @author Nagaraja Settra
 * @param <T>
 */
public abstract class Entity<T> {
    T id;
    String name;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}