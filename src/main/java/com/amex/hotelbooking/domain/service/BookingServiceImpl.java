package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.model.entity.Booking;
import com.amex.hotelbooking.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author Nagaraja Settra
 */
@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        super();
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void add(Booking booking) throws Exception {
        bookingRepository.save(booking);
    }

    @Override
    public void update(Booking booking) throws Exception {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(String id) throws Exception {
        bookingRepository.deleteById(id);
    }

    @Override
    public Optional<Booking> findById(String id) throws Exception {
        return bookingRepository.findById(id);
    }

    @Override
    public Collection<Booking> findByName(String name) throws Exception {
        return bookingRepository.findByName(name);
    }

    @Override
    public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
