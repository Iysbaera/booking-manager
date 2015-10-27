package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;

/**
 * @author Jana Cechackova
 */
public interface HotelDao {

    public void addHotel(Hotel hotel);

    public void updateHotel(Hotel hotel);

    public void deleteHotel(Hotel hotel);

    public Hotel getHotelById(Long Id);

    public Collection<Hotel> findAllHotels();

    public Collection<Room> findFreeRooms();
}
