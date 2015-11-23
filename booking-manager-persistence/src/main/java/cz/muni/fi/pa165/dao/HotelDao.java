package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;

import java.util.Collection;

/**
 * Data Access Object for <tt>Hotel</tt> entity. It provides basic CRUD operations.
 *
 * @see Hotel
 * @author Jana Cechackova
 */
public interface HotelDao {

    /**
     * (C)reates the hotel, meaning persist it into the database.
     *
     * @throws IllegalArgumentException if the hotel is null
     * @param hotel the hotel to be added
     */
    void addHotel(Hotel hotel);

    /**
     * (U)pdates already added (persisted) hotel taken as parameter.
     *
     * @throws IllegalArgumentException if the hotel is null
     * @param hotel the hotel to be updated
     */
    void updateHotel(Hotel hotel);

    /**
     * (D)elete already added (persisted) hotel taken as parameter.
     *
     * @throws IllegalArgumentException if the hotel is null
     * @param hotel the hotel to be updated
     */
    void deleteHotel(Hotel hotel);

    /**
     * (R)etrieve a specific hotel, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the hotel to be retrieved
     * @return found hotel, otherwise null
     */
    Hotel getHotelById(Long id);

    /**
     * (R)etrieve all hotels.
     *
     * @return Collection of all existing hotels,
     *         if there are no hotels empty collection
     */
    Collection<Hotel> findAllHotels();
}
