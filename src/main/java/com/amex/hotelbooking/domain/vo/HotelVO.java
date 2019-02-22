package com.amex.hotelbooking.domain.vo;

import com.amex.hotelbooking.domain.model.entity.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagaraja Settra
 */
public class HotelVO {

    private List<Room> rooms = new ArrayList<>();
    private String name;
    private String id;
    private String address;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
