package cz.muni.fi.pa165.facade;


import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;

/**
 */
public class BookingFacadeImpl implements BookingFacade {
    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public void cancelBooking(Long id) {

    }

    @Override
    public void finishBooking(Long id) {

    }

    @Override
    public Collection<BookingDto> getAllRoomBookings(Room room) {
        return null;
    }

    @Override
    public Collection<BookingDto> getAllHotelBookins(Hotel hotel) {
        return null;
    }

    @Override
    public Collection<BookingDto> getAllBookings() {
        return null;
    }
}
