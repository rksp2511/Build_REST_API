package com.amex.hotelbooking.domain.model.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * @author Nagaraja Settra
 */
@Entity
public class Booking extends BaseEntity<String> {
    private String hotelId;
    private Long roomId;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    /**
     * @param id
     * @param name
     */
    public Booking(String id, String name, String hotelId, Long roomId, LocalDate checkinDate, LocalDate checkoutDate) {
        super(id, name);
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
