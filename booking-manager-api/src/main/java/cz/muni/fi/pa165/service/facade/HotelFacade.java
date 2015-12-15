package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.dto.HotelCreateDto;
import cz.muni.fi.pa165.dto.HotelDto;

import java.util.Collection;

/**
 * Facade for customer operations.
 *
 * @author Ivo Hradek
 */
public interface HotelFacade {
    /**
     * Create a single hotel.
     *
     * @param hotelCreateDto - DTO for creating a hotel.
     * @return Id of created hotel.
     */
    Long createHotel(HotelCreateDto hotelCreateDto);

    /**
     * Remove hotel depending on its id.
     *
     * @param id of hotel to be deleted.
     */
    void deleteHotel(Long id);

    /**
     * Get hotel by its id.
     *
     * @return hotel as data transfer object.
     */
    HotelDto getHotelById(Long id);

    /**
     * Get all hotels.
     *
     * @return Collection of hotel DTOs.
     */
    Collection<HotelDto> getAllHotels();
}
