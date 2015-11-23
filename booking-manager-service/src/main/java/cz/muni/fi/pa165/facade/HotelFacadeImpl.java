package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.HotelCreateDto;
import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Implementation {@link cz.muni.fi.pa165.facade.HotelFacade} interface
 *
 * @see cz.muni.fi.pa165.facade.HotelFacade
 * @author Ivo Hradek
 */
public class HotelFacadeImpl implements HotelFacade {
    @Autowired
    HotelService hotelService;

    @Override
    public Collection<HotelDto> getAllHotels() {
        return null;
    }

    @Override
    public HotelDto getHotelById() {
        return null;
    }

    @Override
    public Long createHotel(HotelCreateDto hotelCreateDto) {
        return null;
    }
}
