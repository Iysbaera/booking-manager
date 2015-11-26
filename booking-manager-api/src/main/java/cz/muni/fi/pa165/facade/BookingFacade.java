package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;

/**
 */
public interface BookingFacade {
    Collection<BookingDto> getAllBookings();
    Collection<BookingDto> getAllHotelBookings(Hotel hotel);
    Collection<BookingDto> getAllRoomBookings(Room room);
    BookingDto getBookingById(Long id);
}
