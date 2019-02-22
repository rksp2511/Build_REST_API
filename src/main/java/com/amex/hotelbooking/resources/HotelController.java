package com.amex.hotelbooking.resources;

import com.amex.hotelbooking.domain.model.entity.Hotel;
import com.amex.hotelbooking.domain.service.HotelService;
import com.amex.hotelbooking.domain.vo.HotelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Nagaraja Settra
 */
@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

    /**
     * Logger
     */
    protected Logger logger = LoggerFactory.getLogger(HotelController.class);

    /**
     * Hotel service
     */
    protected HotelService hotelService;

    /**
     *
     * @param hotelService
     */
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Fetch all hotels <code>http://.../v1/hotels/</code>
     * @return collection of hotels
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Hotel>> findAll() {
        logger.info(String.format("hotelService findAll invoked:{}", hotelService.getClass().getName()));

        Collection<Hotel> hotels;
        try {
            hotels = hotelService.findAll();
        } catch (Exception e) {
            logger.error("Exception raised by findAll REST call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return hotels.size() > 0 ? new ResponseEntity<>(hotels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get hotels with the specified name <code>http://.../v1/hotels</code>.
     * At this point hotel names are not case sensitive
     * @param name hotel name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Hotel>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("hotelService findByName invoked: %s for %s ", hotelService.getClass().getName(), name));
        name = name.trim().toLowerCase();

        Collection<Hotel> hotels;
        try {
            hotels = hotelService.findByName(name);
        } catch (Exception e) {
            logger.error("Exception raised by findByName REST call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return hotels.size() > 0 ? new ResponseEntity<>(hotels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Find hotel with the given id. <code>http://.../v1/hotels/{hotel_id}</code> will return
     * hotel with the given id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{hotel_id}", method = RequestMethod.GET)
    public ResponseEntity<Hotel> findById(@PathVariable("hotel_id") String id) {
        logger.info(String.format("hotelService findById invoked: {} for {} ", hotelService.getClass().getName(), id));
        id = id.trim();
        Optional<Hotel> hotel;
        try {
            hotel = hotelService.findById(id);
        } catch (Exception e) {
            logger.warn("Exception raised by findById REST call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return hotel.isPresent() ? new ResponseEntity<>(hotel.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Add hotel with the specified information
     *
     * @param hotelVO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Hotel> add(@RequestBody HotelVO hotelVO) {
        logger.info(String.format("hotelService add() invoked: %s for %s ", hotelService.getClass().getName(), hotelVO.getName()));

        Hotel hotel = new Hotel(null, null, null, null);
        BeanUtils.copyProperties(hotelVO, hotel);
        try {
            hotelService.add(hotel);
        } catch (Exception e) {
            logger.warn("Exception raised for add hotel REST call {0}", e);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
