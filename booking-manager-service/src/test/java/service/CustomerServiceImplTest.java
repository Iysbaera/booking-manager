package service;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.service.CustomerService;
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
import static org.mockito.Matchers.any;

import static org.mockito.Mockito.when;

/**
 * @author Jana Cechackova
 */

@ContextConfiguration(locations = {"classpath:application-context-service-test.xml"})
public class CustomerServiceImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DozerBeanMapper mapper;

    @Mock
    CustomerDao customerDao;

    Customer c1;

    Date d;

    @Autowired
    @InjectMocks
    CustomerService customerService;

    @BeforeMethod
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        String sourceDate = "2015-01-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        d = format.parse(sourceDate);

        c1 = new Customer();
        c1.setForename("Customer 1");


    }

    @Test
    public void testAddCustomer() {
        customerService.addCustomer(c1);

        when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
        Assert.assertNotNull(customerService.getCustomerById(c1.getId()));
    }

    @Test
    public void testUpdateCustomer() {
        customerService.addCustomer(c1);
        c1.setForename("Customer 2");
        customerService.updateCustomer(c1);

	when(customerDao.getCustomerById(1L).getForename()).thenReturn("Customer 2");
        Assert.assertEquals(customerService.getCustomerById(1L).getForename(), c1.getForename());
    }

    @Test
    public void testDeleteCustomer() {
        customerService.addCustomer(c1);

        when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
        Assert.assertNotNull(customerService.getCustomerById(c1.getId()));

        customerService.deleteCustomer(c1);
        when(customerDao.getCustomerById(c1.getId())).thenReturn(null);
        Assert.assertNull(customerService.getCustomerById(c1.getId()));
    }

    @Test
    public void testGetBookingById() {
        customerService.addCustomer(c1);

        when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
        Customer output = customerService.getCustomerById(c1.getId());

        Assert.assertEquals(output, c1);
    }

//    @Test
//    public void testGetAllBookedCustomers(){
//
//	c1.setForename("Customer 1");
//	Customer c2 = new Customer();
//	c2.setForename("Customer 2");
//	Customer c3 = new Customer();
//	c3.setForename("Customer 3");
//
//	Hotel h = new Hotel();
//
//	Booking b1 = new Booking();
//	Booking b2 = new Booking();
//	Booking b3 = new Booking();
//
//	Room r1 = new Room();
//	Room r2 = new Room();
//	Room r3 = new Room();
//
//        r1.setPrice(new BigDecimal("10"));
//	r2.setPrice(new BigDecimal("10"));
//	r3.setPrice(new BigDecimal("10"));
//
//	r1.setType(RoomType.SingleRoom);
//	r2.setType(RoomType.SingleRoom);
//	r3.setType(RoomType.SingleRoom);
//
//	r1.setId(1l);
//	r2.setId(2l);
//	r3.setId(3l);
//
//	r1.setHotel(h);
//	r2.setHotel(h);
//	r3.setHotel(h);
//
//	r1.setNumber(101);
//	r2.setNumber(102);
//	r3.setNumber(103);
//
//	h.addRoom(r1);
//	h.addRoom(r2);
//	h.addRoom(r3);
//
//	b1.setCustomer(c1);
//	b1.setCheckIn(d);
//	b1.setCheckOut(addDays(d,3));
//	b1.setRoom(r1);
//
//
//	b2.setCustomer(c2);
//	b2.setCheckIn(d);
//	b2.setCheckOut(addDays(d,2));
//	b2.setRoom(r2);
//
//	b3.setCustomer(c3);
//	b3.setCheckIn(d);
//	b3.setCheckOut(addDays(d,1));
//	b3.setRoom(r3);
//
//	customerService.addCustomer(c1);
//	customerService.addCustomer(c2);
//	customerService.addCustomer(c3);
//
//	Collection<Customer> customers = new ArrayList<Customer>();
//
//	customers.add(c1);
//	customers.add(c2);
//	customers.add(c3);
//
//	when(customerDao.findAllCustomers()).thenReturn(customers);
//	Assert.assertEquals(customerService.getAllBookedCustomers(d, h), customers);
//
//	customers.remove(c1);
//
//	when(customerDao.findAllCustomers()).thenReturn(customers);
//	Assert.assertEquals(customerService.getAllBookedCustomers(addDays(d,1), h), customers);
//
//	customers.remove(c2);
//
//	when(customerDao.findAllCustomers()).thenReturn(customers);
//	Assert.assertEquals(customerService.getAllBookedCustomers(addDays(d,2), h), customers);
//    }


    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}