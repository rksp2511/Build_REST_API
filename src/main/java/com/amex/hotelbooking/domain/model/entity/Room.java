package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.Entity;

/**
 * @author Nagaraja Settra
 */
@Entity
public class Room extends BaseEntity<Long> {

    private String bedType;

    /**
     * @param id
     * @param name
     */
    public Room(Long id, String name, String bedType) {
        super(id, name);
        this.bedType = bedType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
