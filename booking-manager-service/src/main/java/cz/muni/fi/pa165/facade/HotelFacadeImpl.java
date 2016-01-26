package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.CreateHotelDto;
import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.service.HotelService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link HotelFacade} interface
 *
 * @author Ivo Hradek
 * @see HotelFacade
 */
@Service
@Transactional
public class HotelFacadeImpl implements HotelFacade {
    @Autowired
    HotelService hotelService;

    @Autowired
    Mapper mapper;

    @Override
    public Collection<HotelDto> getAllHotels() {
        return (Collection) ((List) hotelService.getAllHotels()).stream()
                .map(b -> mapper.map(b, HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long updateHotel(HotelDto hotelDto) {
        Hotel hotel = hotelService.getHotelById(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotelService.updateHotel(hotel);
        return hotel.getId();
    }

    @Override
    public HotelDto getHotelById(Long id) {
        return mapper.map(hotelService.getHotelById(id), HotelDto.class);
    }

    @Override
    public Long createHotel(CreateHotelDto hotelCreateDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelCreateDto.getName());
        hotelService.addHotel(hotel);
        return hotel.getId();
    }

    @Override
    public void deleteHotel(Long id) {
        hotelService.deleteHotel(hotelService.getHotelById(id));
    }
}
