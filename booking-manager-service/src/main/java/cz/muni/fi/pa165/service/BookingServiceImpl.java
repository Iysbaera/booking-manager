package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Booking;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jana Cechackova
 */
@Service("bookingService")
public class BookingServiceImpl implements BookingService{
   
    BookingDao bookingDao;
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void addBooking(BookingDto bookingDto) {
	
	Booking booking;
	
	booking = mapper.map(bookingDto, Booking.class);
	bookingDto.setId(booking.getId());
	bookingDao.addBooking(booking);    
    }

    @Override
    public void deleteBooking(BookingDto bookingDto) {
	
	Booking booking;
	
	booking = mapper.map(bookingDto, Booking.class);
	bookingDao.deleteBooking(booking);    
    }

    @Override
    public void updateBooking(BookingDto bookingDto) {
	
	Booking booking;
    
	booking = mapper.map(bookingDto, Booking.class);
	bookingDao.updateBooking(booking);
    }

    @Override
    public BookingDto getBookingDtoById(Long id) {
	
	//not implemented yet
	
	return null;    
    }
    
    
    
}
