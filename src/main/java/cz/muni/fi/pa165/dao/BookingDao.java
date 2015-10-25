package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Booking;

/**
 * @author Jana Cechackova
 */
public interface BookingDao {
   
    public void addBooking(Booking booking);
    
    public void updateBooking(Booking booking);
    
    public void deleteBooking(Booking booking);
    
    public Booking getBookingById(Long Id);    
    
}
