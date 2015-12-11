package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Booking;

import java.util.Collection;

/**
 * @author Jana Cechackova
 */
public interface BookingService {

    /**
     * Method to add a new booking.
     *
     * @param booking new booking to add
     */
    void addBooking(Booking booking);

    /**
     * Method to delete a specific booking.
     *
     * @param booking specific booking to be deleted
     */
    void deleteBooking(Booking booking);

    /**
     * Method to update a specific booking meaning update its parameters.
     *
     * @param booking booking to be updated
     */
    void updateBooking(Booking booking);

    /**
     * Method to get desired booking by its ID.
     *
     * @param id id of desired booking
     * @return booking with a matching ID
     */
    Booking getBookingById(Long id);

    /**
     * Method to get all bookings.
     *
     * @return a collection of all bookings
     */
    Collection<Booking> getAllBookings();

    /**
     * Create a booking.
     *
     * @param booking to be created.
     * @return Created booking.
     */
    Booking createBooking(Booking booking);
}