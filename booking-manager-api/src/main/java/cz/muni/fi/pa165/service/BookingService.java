package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dto.BookingDto;

/**
 *
 * @author Jana Cechackova
 */
public interface BookingService {
    
    public void addBooking(BookingDto bookingDto);
    public void deleteBooking(BookingDto bookingDto);
    public void updateBooking(BookingDto bookingDto);
    public BookingDto getBookingDtoById(Long id);
    
}
