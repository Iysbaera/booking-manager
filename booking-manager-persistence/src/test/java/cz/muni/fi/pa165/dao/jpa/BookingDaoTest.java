package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.entity.Room;
import org.mockito.Mock;
import org.mockito.Mockito;
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
import java.util.List;

/**
 * @author Juraj Bielik
 */
@ContextConfiguration("classpath:application-context-persistence-test.xml")
public class BookingDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private BookingDao bookingDao;

    @Mock
    private Room room1;
    @Mock
    private Customer customer1;

    private Booking booking1;

    /* Helper */
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Date checkIn;
    private Date checkOut;

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    @BeforeMethod
    public void setUp() throws ParseException {
        checkIn = format.parse("2116-02-29");
        checkOut = format.parse("2116-02-30");
        booking1 = new Booking();
        booking1.setCheckIn(checkIn);
        booking1.setCheckOut(checkOut);
    }

    /**
     * Test of addBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testAddBooking() {
        bookingDao.addBooking(booking1);
        Assert.assertNotNull(booking1.getId());
        Assert.assertEquals(bookingDao.getBookingById(booking1.getId()).getCheckIn(), checkIn);
    }

    /**
     * Test of updateBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testUpdateBooking() {
        bookingDao.addBooking(booking1);
        Assert.assertNotNull(bookingDao.getBookingById(booking1.getId()));
        Date newDate = addDays(checkIn, 1);
        booking1.setCheckIn(newDate);
        bookingDao.updateBooking(booking1);
        Assert.assertEquals(bookingDao.getBookingById(booking1.getId()).getCheckIn(), newDate);
    }

    /**
     * Test of deleteBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testDeleteBooking() {
        bookingDao.addBooking(booking1);
        Assert.assertNotNull(bookingDao.getBookingById(booking1.getId()));

        bookingDao.deleteBooking(booking1);
        Assert.assertNull(bookingDao.getBookingById(booking1.getId()));
    }

    /**
     * Test of getBookingById method, of class BookingDaoImpl.
     */
    @Test
    public void testGetBookingById() {
        bookingDao.addBooking(booking1);
        Booking output = bookingDao.getBookingById(booking1.getId());
        Assert.assertEquals(output.getCheckIn(), booking1.getCheckIn());
    }

    /**
     * Test of findAllBookings method, of class BookingDaoImpl.
     */
    @Test
    public void testFindAllBookings() {
        bookingDao.addBooking(booking1);
        List<Booking> bookings = (List) bookingDao.findAllBookings();

        Assert.assertTrue(bookings.size() == 1, "Collection of bookings size");
        Assert.assertSame(bookings.get(0), booking1, "Different booking");
    }
}
