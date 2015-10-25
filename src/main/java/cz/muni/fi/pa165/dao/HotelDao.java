package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;

/**
 * @author Jana Cechackova
 */
public interface HotelDao {
    
    public void addHotel(Hotel hotel);
    
    public void updateHotel(Hotel hotel);
    
    public void deleteHotel(Hotel hotel);
    
    public Hotel getHotelById(Long Id);
    
}
