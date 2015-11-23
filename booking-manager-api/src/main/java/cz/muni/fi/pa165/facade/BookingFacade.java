package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;

/**
 */
public interface BookingFacade {
    Collection<BookingDto> getAllBookings();
    Collection<BookingDto> getAllHotelBookins(Hotel hotel);
    Collection<BookingDto> getAllRoomBookings(Room room);
    void finishBooking(Long id);
    void cancelBooking(Long id);
    Booking getBookingById(Long id);
}
