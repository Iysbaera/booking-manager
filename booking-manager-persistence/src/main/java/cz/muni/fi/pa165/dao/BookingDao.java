package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Booking;

/**
 * Data Access Object for <tt>Booking</tt> entity. It provides basic CRUD operations.
 *
 * @see Booking
 * @author Jana Cechackova
 */
public interface BookingDao {

    /**
     * (C)reates the booking, meaning persist it into the database.
     *
     * @throws IllegalArgumentException if the booking is null
     * @param booking the booking to be added
     */
    void addBooking(Booking booking);

    /**
     * (U)pdates already added (persisted) booking taken as parameter.
     *
     * @throws IllegalArgumentException if the booking is null
     * @param booking the booking to be updated
     */
    void updateBooking(Booking booking);

    /**
     * (D)elete already added (persisted) booking taken as parameter.
     *
     * @throws IllegalArgumentException if the booking is null
     * @param booking the booking to be updated
     */
    void deleteBooking(Booking booking);

    /**
     * (R)etrieve a specific booking, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the booking to be retrieved
     * @return found booking, otherwise null
     */
    Booking getBookingById(Long id);
}
