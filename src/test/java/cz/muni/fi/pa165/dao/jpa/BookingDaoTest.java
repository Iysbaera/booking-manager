/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.entity.Booking;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.datatype.DatatypeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional

@ContextConfiguration("classpath:applicationContextTest.xml")
public class BookingDaoTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private BookingDao bookingDao;
    
    private Booking booking1;
    private Booking booking2;
    
    Date d = new Date();
    

    @BeforeMethod
    public void setUp() throws ParseException {
        booking1 = new Booking();
        booking2 = new Booking();
        String sourceDate = "2012-02-29";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        d = format.parse(sourceDate);
        booking1.setCheckIn(d);
    }

    /**
     * Test of addBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testAddBooking() {
        bookingDao.addBooking(booking1);
        Assert.assertEquals(bookingDao.getBookingById(booking1.getId()).getCheckIn(), d);
    }

    /**
     * Test of updateBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testUpdateBooking() {
     bookingDao.addBooking(booking1);
     Assert.assertNotNull(bookingDao.getBookingById(booking1.getId()));
     Date newDate = addDays(d,1);
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
    
    public static Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
