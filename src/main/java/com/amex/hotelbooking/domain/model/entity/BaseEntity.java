package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.MappedSuperclass;

/**
 * @author Nagaraja Settra
 */
@MappedSuperclass
public abstract class BaseEntity<T> extends Entity<T> {
    private boolean modified;

    /**
     *
     * @param id
     * @param name
     */
    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        this.modified = false;
    }

    /**
     *
     * @return
     */
    public boolean isModified() {
        return modified;
    }

}
