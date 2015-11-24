package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jana Cechackova
 */
@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDao bookingDao;

    @Override
    public void addBooking(Booking booking) {
        bookingDao.addBooking(booking);
    }

    @Override
    public void deleteBooking(Booking booking) {
        bookingDao.deleteBooking(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingDao.getBookingById(id);
    }
}
