/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Customer;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;

/**
 * @author Juraj Bielik
 */
@ContextConfiguration("classpath:application-context-persistence-test.xml")
public class CustomerDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private CustomerDao customerDao;

    private Customer c1;
    private Customer c2;

    @Mock
    private Booking b1;
    @Mock
    private Booking b2;
    @Mock
    private Booking b3;

    @BeforeMethod
    public void setUp() {
        c1 = new Customer();
        c1.setForename("Customer 1");
        c1.setSurname("Customer 1 surname");

        c2 = new Customer();
        c2.setForename("Customer 2");
        c2.setSurname("Customer 2 surname");
    }

    /**
     * Test of addCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testAddCustomer() {
        /* Create mock bookings */
        b1 = Mockito.mock(Booking.class);
        b2 = Mockito.mock(Booking.class);

        /* Customer with bookings */
        c1.addBooking(b1);
        c1.addBooking(b2);
        customerDao.addCustomer(c1);

        /* Customer without bookings */
        customerDao.addCustomer(c2);

        /* Customers were added */
        Assert.assertNotNull(c1.getId());
        Assert.assertNotNull(c2.getId());

        /* Bookings were added too */
        int customer1Bookings =
                customerDao.getCustomerById(c1.getId())
                        .getBookings()
                        .size();
        Assert.assertSame(customer1Bookings, c1.getBookings().size(),
                "Number of customer 1 bookings is not same");

        int customer2Bookings =
                customerDao.getCustomerById(c2.getId())
                        .getBookings()
                        .size();
        Assert.assertSame(customer2Bookings, c2.getBookings().size(),
                "Number of customer 2 bookings is not same");

        /* The same bookings were added */
        for (Booking b : c1.getBookings()) {
            Assert.assertNotNull(b.getId(), "Bookings weren't added to customer 1");
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddNullCustomer() {
        customerDao.addCustomer(null);
        Assert.fail("Adding null customer");
    }

    /**
     * Test of updateCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testUpdateCustomer() {
        /* Create mock bookings */
        b1 = Mockito.mock(Booking.class);
        b2 = Mockito.mock(Booking.class);
        b3 = Mockito.mock(Booking.class);

        c1.addBooking(b1);
        c1.addBooking(b2);
        c1.setForename("Customer");
        customerDao.addCustomer(c1);

        /* Update name */
        c1.setForename("Customer 1");
        customerDao.updateCustomer(c1);

        String actualName = customerDao.getCustomerById(c1.getId()).getForename();
        Assert.assertEquals(actualName, c1.getForename(), "Customer 1 name was not updated");

        /* Were bookings modified? */
        int customer1Bookings = customerDao.getCustomerById(c1.getId()).getBookings().size();
        Assert.assertEquals(customer1Bookings, c1.getBookings().size(),
                "Customer 1 bookings were changed");

        c1.addBooking(b3);

        /* Was booking 3 added? */
        customer1Bookings = customerDao.getCustomerById(c1.getId()).getBookings().size();
        Assert.assertNotNull(b3.getId(), "Booking was not added to customer 1");
        Assert.assertEquals(customer1Bookings, c1.getBookings().size(),
                "Booking was not added to customer 1");
    }

    /**
     * Test of deleteCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testDeleteCustomer() {
        /* Create mock bookings */
        b1 = Mockito.mock(Booking.class);
        b2 = Mockito.mock(Booking.class);

        c1.addBooking(b1);
        c1.addBooking(b2);
        customerDao.addCustomer(c1);
        Assert.assertNotNull(c1.getId(), "Customer 1 was not added");

        /* Was customer deleted? */
        customerDao.deleteCustomer(c1);
        Customer actualCustomer = customerDao.getCustomerById(c1.getId());
        Assert.assertNull(actualCustomer, "Customer 1 was not deleted");

        /* Were bookings deleted? */
        for (Booking b : c1.getBookings()) {
            Assert.assertNull(b.getId(), "Bookings of customer 1 weren't deleted");
        }
    }

    /**
     * Test of getCustomerById method, of class CustomerDaoImpl.
     */
    @Test
    public void testGetCustomerById() {
        c1.addBooking(b1);
        c1.addBooking(b2);
        customerDao.addCustomer(c1);

        Customer actualCustomer = customerDao.getCustomerById(c1.getId());
        Assert.assertEquals(actualCustomer.getForename(), c1.getForename(),
                "Name of customer 1 is not the same");

        Collection<Booking> actualBookingsOfC1 = actualCustomer.getBookings();
        Assert.assertEquals(actualBookingsOfC1, c1.getBookings(),
                "Customer 1 doesn't have the same bookings");
    }

    /**
     * Test of findAllCustomers method, of class CustomerDaoImpl.
     */
    @Test
    public void testFindAllCustomers() {
        customerDao.addCustomer(c1);
        customerDao.addCustomer(c2);

        List<Customer> customerList = (List) customerDao.findAllCustomers();
        Assert.assertTrue(customerList.size() == 2, "Customer collection's size");
        Assert.assertTrue(customerList.contains(c1), "Doesn't contain same customer");
        Assert.assertTrue(customerList.contains(c2), "Doesn't contain same customer");
    }
}
