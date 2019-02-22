package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Nagaraja Settra
 * @param <T>
 */
@MappedSuperclass
public abstract class Entity<T> {

    @Id
    T id;

    String name;

    public Entity() {
    }

    public Entity(T id, String name) {
        this.id = id;
        this.name = name;
    }

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
