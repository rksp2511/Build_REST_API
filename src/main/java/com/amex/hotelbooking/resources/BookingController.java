package com.amex.hotelbooking.resources;

import com.amex.hotelbooking.domain.model.entity.Booking;
import com.amex.hotelbooking.domain.service.BookingService;
import com.amex.hotelbooking.domain.vo.BookingVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/v1/booking")
@Api(value = "booking", description = "Booking rooms and existing booking lookup service", tags = "booking")
public class BookingController {

    /**
     * Logger
     */
    protected Logger logger = LoggerFactory.getLogger(BookingController.class);

    /**
     * Booking service
     */
    protected BookingService bookingService;

    /**
     *
     * @param bookingService
     */
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Get bookings with the specified name <code>http://.../v1/booking</code>.
     * @param name booking name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find booking", notes = "Finds an existing booking by it's name", nickname = "findBookingByName")
    public ResponseEntity<Collection<Booking>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("bookingService findByName invoked: %s for %s ", bookingService.getClass().getName(), name));

        Collection<Booking> bookings;
        try {
            bookings = bookingService.findByName(name);
        } catch (Exception e) {
            logger.error("Exception raised by findByName REST call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return bookings.size() > 0 ? new ResponseEntity<>(bookings, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Find booking with the given id. <code>http://.../v1/booking/{id}</code> will return
     * booking with the given id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Find booking by id", notes = "Finds an existing booking by it's id", nickname = "findBookingById")
    public ResponseEntity<Booking> findById(@PathVariable("id") String id) {
        logger.info(String.format("bookingService findById invoked: %s for %s ", bookingService.getClass().getName(), id));
        id = id.trim();
        Optional<Booking> booking;
        try {
            booking = bookingService.findById(id);
        } catch (Exception e) {
            logger.warn("Exception raised by findById REST call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return booking.isPresent() ? new ResponseEntity<>(booking.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Add booking with the specified information
     *
     * @param bookingVO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Make new booking", notes = "Makes new booking for a room in a hotel", nickname = "makeNewBooking")
    public ResponseEntity<Booking> add(@RequestBody BookingVO bookingVO) {
        logger.info(String.format("bookingService add() invoked: %s for %s ", bookingService.getClass().getName(), bookingVO.getName()));

        Booking booking = new Booking(null, null, null, null, null, null);
        BeanUtils.copyProperties(bookingVO, booking);
        try {
            bookingService.add(booking);
        } catch (Exception e) {
            logger.warn("Exception raised for add booking REST call {0}", e);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
