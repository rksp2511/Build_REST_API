package com.amex.hotelbooking.domain.service;

import com.amex.hotelbooking.domain.model.entity.Hotel;
import com.amex.hotelbooking.domain.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Nagaraja Settra
 */
@Service
public class HotelServiceImpl extends BaseService<Hotel, String> implements HotelService {

    private HotelRepository<Hotel, String> hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository<Hotel, String> repository) {
        super(repository);
        this.hotelRepository = repository;
    }

    @Override
    public void add(Hotel hotel) throws Exception {
        if (hotelRepository.containsName(hotel.getName())) {
            throw new Exception(String.format("There is already a hotel with the name - %s", hotel.getName()));
        }

        if (hotel.getName() == null || hotel.getName().isEmpty()) {
            throw new Exception("Hotel name cannot be null or empty.");
        }
        super.add(hotel);
    }

    @Override
    public void update(Hotel hotel) throws Exception {
        hotelRepository.save(hotel);
    }

    @Override
    public void delete(String id) throws Exception {
        hotelRepository.deleteById(id);
    }

    @Override
    public Optional<Hotel> findById(String hotelId) throws Exception {
        return hotelRepository.findById(hotelId);
    }

    @Override
    public Collection<Hotel> findByName(String name) throws Exception {
        return hotelRepository.findByName(name);
    }

    @Override
    public Collection<Hotel> findAll() throws Exception {
        List<Hotel> allItems = new ArrayList<>();
        hotelRepository.findAll().forEach(allItems::add);
        return allItems;
    }

    @Override
    public Collection<Hotel> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        return null;
    }
}
