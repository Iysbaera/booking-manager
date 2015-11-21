package cz.muni.fi.pa165.service;
import cz.muni.fi.pa165.dto.HotelDto;

/**
 *
 * @author Jana Cechackova
 */
public interface HotelService {
    
    public void addHotel(HotelDto hotelDto);
    public void deleteHotel(HotelDto hotelDto);
    public void updateHotel(HotelDto hotelDto);
    public HotelDto getHotelDtoById(Long id);
}
