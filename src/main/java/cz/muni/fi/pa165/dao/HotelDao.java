package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

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
    public void addHotel(Hotel hotel);

    /**
     * (U)pdates already added (persisted) hotel taken as parameter.
     *
     * @throws IllegalArgumentException if the hotel is null
     * @param hotel the hotel to be updated
     */
    public void updateHotel(Hotel hotel);

    /**
     * (D)elete already added (persisted) hotel taken as parameter.
     *
     * @throws IllegalArgumentException if the hotel is null
     * @param hotel the hotel to be updated
     */
    public void deleteHotel(Hotel hotel);

    /**
     * (R)etrieve a specific hotel, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the hotel to be retrieved
     */
    public Hotel getHotelById(Long id);

    public Collection<Hotel> findAllHotels();

    public Collection<Room> findFreeRooms();
}
