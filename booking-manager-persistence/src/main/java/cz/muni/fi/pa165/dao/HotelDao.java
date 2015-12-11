package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;

import java.util.Collection;

/**
 * Data Access Object for <tt>Hotel</tt> entity.
 * It provides basic CRUD operations.
 *
 * @author Jana Cechackova
 * @see Hotel
 */
public interface HotelDao {

    /**
     * (C)reates the hotel, meaning persist it into the database.
     *
     * @param hotel the hotel to be added
     * @throws IllegalArgumentException if the hotel is null
     */
    void addHotel(Hotel hotel);

    /**
     * (U)pdates already added (persisted) hotel taken as parameter.
     *
     * @param hotel the hotel to be updated
     * @throws IllegalArgumentException if the hotel is null
     */
    void updateHotel(Hotel hotel);

    /**
     * (D)elete already added (persisted) hotel taken as parameter.
     *
     * @param hotel the hotel to be updated
     * @throws IllegalArgumentException if the hotel is null
     */
    void deleteHotel(Hotel hotel);

    /**
     * (R)etrieve a specific hotel, which has een already created.
     *
     * @param id the id of the hotel to be retrieved
     * @return found hotel, otherwise null
     * @throws IllegalArgumentException if the id is null
     */
    Hotel getHotelById(Long id);

    /**
     * (R)etrieve all hotels.
     *
     * @return Collection of all existing hotels,
     * if there are no hotels empty collection
     */
    Collection<Hotel> findAllHotels();
}
