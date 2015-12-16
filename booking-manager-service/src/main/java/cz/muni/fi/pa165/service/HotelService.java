package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Hotel;

import java.util.Collection;

/**
 * @author Jana Cechackova
 */
public interface HotelService {

    /**
     * Method to add a new hotel.
     *
     * @param hotel new hotel to be added
     * @return added hotel
     */
    Hotel addHotel(Hotel hotel);

    /**
     * Method to delete a specific hotel.
     *
     * @param hotel specific hotel to be deleted
     */
    void deleteHotel(Hotel hotel);

    /**
     * Method to update a hotel meaning update its parameters.
     *
     * @param hotel hotel to be updated
     */
    void updateHotel(Hotel hotel);

    /**
     * Method to get a hotel by its ID.
     *
     * @param id ID of a hotel
     * @return a hotel with a matching ID
     */
    Hotel getHotelById(Long id);

    /**
     * Method to get all hotels.
     *
     * @return a collection of all hotels
     */
    Collection<Hotel> getAllHotels();
}