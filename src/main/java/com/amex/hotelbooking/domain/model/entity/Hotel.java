package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagaraja Settra
 */
@Entity
@Table(name = "HOTEL")
public class Hotel extends BaseEntity<String> {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="HOTEL_ID")
    private List<Room> rooms;

    @Column(name="ADDRESS")
    private String address;

    public Hotel() {
        super();
    }

    /**
     * @param id
     * @param name
     */
    public Hotel(String id, String name, String address, List<Room> rooms) {
        super(id, name);
        this.address = address;
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        //room.setHotel(this);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
