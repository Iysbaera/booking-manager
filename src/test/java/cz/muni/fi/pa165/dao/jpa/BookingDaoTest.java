/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.BookingDao;
import javax.transaction.Transactional;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingDaoTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private BookingDao bookingDao;
    
    @Before
    public void setUp() {

    }
    
    /**
     * Test of addBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testAddBooking() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testUpdateBooking() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBooking method, of class BookingDaoImpl.
     */
    @Test
    public void testDeleteBooking() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingById method, of class BookingDaoImpl.
     */
    @Test
    public void testGetBookingById() {
        fail("The test case is a prototype.");
    }
    
}
