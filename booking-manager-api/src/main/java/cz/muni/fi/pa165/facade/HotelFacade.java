package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.HotelCreateDto;
import cz.muni.fi.pa165.dto.HotelDto;

import java.util.Collection;

/**
 * Facade
 */
public interface HotelFacade {
    /**
     * @param hotelCreateDto -
     * @return id of created hotel
     */
    Long createHotel(HotelCreateDto hotelCreateDto);

    /**
     * @return hotel as data access object
     */
    HotelDto getHotelById(Long id);

    /**
     * @return Collection
     */
    Collection<HotelDto> getAllHotels();
}
