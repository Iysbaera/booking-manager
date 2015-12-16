package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Jana Cechackova
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelDao hotelDao;

    @Override
    public Hotel addHotel(Hotel hotel) {
        hotelDao.addHotel(hotel);
	return hotel;
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelDao.deleteHotel(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelDao.updateHotel(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelDao.getHotelById(id);
    }

    @Override
    public Collection<Hotel> getAllHotels() {
        return hotelDao.findAllHotels();
    }
}
