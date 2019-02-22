package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagaraja Settra
 */
@Entity(name = "Hotel")
@Table(name = "HOTEL")
public class Hotel extends BaseEntity<String> {

    private List<Room> rooms = new ArrayList<>();
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
