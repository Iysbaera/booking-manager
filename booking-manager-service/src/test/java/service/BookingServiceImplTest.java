package service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.service.BookingService;
import org.dozer.DozerBeanMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.when;

/**
 * @author Jana Cechackova
 */
@ContextConfiguration("classpath:application-context-service-test.xml")
public class BookingServiceImplTest extends AbstractTransactionalTestNGSpringContextTests{

    @Autowired
    DozerBeanMapper mapper;

    @Mock
    BookingDao bookingDao;

    Booking booking;

    Date d;

    @Autowired
    @InjectMocks
    BookingService bookingService;

    @BeforeMethod
    public void setUp() throws ParseException{
        MockitoAnnotations.initMocks(this);
	booking = new Booking();
	String sourceDate = "2012-02-29";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        d = format.parse(sourceDate);
        booking.setCheckIn(d);
    }

    @Test
    public void testAddBooking(){
	when(bookingDao.getBookingById(booking.getId())).thenReturn(booking);

	bookingService.addBooking(booking);
	Assert.assertEquals(bookingService.getBookingById(booking.getId()).getCheckIn(), d);
    }

    @Test
    public void testUpdateBooking(){
	bookingService.addBooking(booking);

	Date newDate = addDays(d,1);
	booking.setCheckIn(newDate);
	bookingService.updateBooking(booking);

	when(bookingDao.getBookingById(booking.getId())).thenReturn(booking);
	Assert.assertEquals(bookingService.getBookingById(booking.getId()).getCheckIn(), newDate);
    }

    @Test
    public void testDeleteBooking(){
	bookingDao.addBooking(booking);

	when(bookingDao.getBookingById(booking.getId())).thenReturn(booking);
        Assert.assertNotNull(bookingService.getBookingById(booking.getId()));

        bookingDao.deleteBooking(booking);

	when(bookingDao.getBookingById(booking.getId())).thenReturn(null);
        Assert.assertNull(bookingService.getBookingById(booking.getId()));
    }

    @Test
    public void testGetBookingById(){
        bookingService.addBooking(booking);

	when(bookingDao.getBookingById(booking.getId())).thenReturn(booking);
	Booking output = bookingService.getBookingById(booking.getId());

        Assert.assertEquals(output.getCheckIn(), booking.getCheckIn());
    }

    public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
