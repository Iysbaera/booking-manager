package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Jana Cechackova
 */
@Service
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
    public Booking createBooking(Booking booking) {
        bookingDao.addBooking(booking);
        return booking;
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingDao.getBookingById(id);
    }

    @Override
    public Collection<Booking> getAllBookings() {
        return bookingDao.findAllBookings();
    }
}
