package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * @author Nagaraja Settra
 */
@Entity
@Table(name="ROOM")
public class Room extends BaseEntity<Long> {

    @Column(name="ROOM_NUMBER")
    private String roomNumber;

    @Column(name="BED_TYPE")
    private String bedType;

    public Room() {
        super();
    }
    /**
     * @param id
     * @param name
     */
    public Room(Long id, String name, String bedType) {
        super(id, name);
        this.bedType = bedType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

}
