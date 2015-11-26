package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jana Cechackova
 */
@Transactional
@ContextConfiguration(locations = {"classpath:/application-context-service-test.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class BookingServiceImplTest {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Mock
    BookingDao bookingDao;
    
    Booking booking;
    
    Date d;

    @Autowired
    BookingService bookingService;
    
    @BeforeMethod
    public void setUp() throws ParseException{
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(bookingService, "bookingDao", bookingDao);
	booking = new Booking();
	String sourceDate = "2012-02-29";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        d = format.parse(sourceDate);
        booking.setCheckIn(d);
    }
    
    @Test
    public void testAddBooking(){
	bookingService.addBooking(booking);
	Assert.assertEquals(bookingDao.getBookingById(booking.getId()).getCheckIn(), d);
    }
    
    @Test
    public void testUpdateBooking(){
	bookingService.addBooking(booking);
	
	Date newDate = addDays(d,1);
	booking.setCheckIn(newDate);
	bookingDao.updateBooking(booking);
	Assert.assertEquals(bookingDao.getBookingById(booking.getId()).getCheckIn(), newDate);
    }
    
    @Test
    public void testDeleteBooking(){
	bookingDao.addBooking(booking);
        Assert.assertNotNull(bookingDao.getBookingById(booking.getId()));

        bookingDao.deleteBooking(booking);
        Assert.assertNull(bookingDao.getBookingById(booking.getId()));
    }
    
    @Test
    public void testGetBookingById(){
        bookingDao.addBooking(booking);
        Booking output = bookingDao.getBookingById(booking.getId());
        Assert.assertEquals(output.getCheckIn(), booking.getCheckIn());
    }

    @Test
    public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
