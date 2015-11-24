package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Hotel;

import java.util.Collection;

/**
 *
 * @author Jana Cechackova
 */
public interface HotelService {
    void addHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    Hotel getHotelById(Long id);
    Collection<Hotel> getAllHotels();
}
