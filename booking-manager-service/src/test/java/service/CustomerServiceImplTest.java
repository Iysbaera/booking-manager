package service;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.service.CustomerService;
import java.text.ParseException;
import java.util.Date;
import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.mockito.InjectMocks;
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
@ContextConfiguration(locations = {"classpath:application-context-service-test.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class CustomerServiceImplTest {
    
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
    public void setUp() throws ParseException{
        MockitoAnnotations.initMocks(this);
	c1 = new Customer();
        c1.setForename("Customer 1");
    }
    
    @Test
    public void testAddCustomer(){
	customerService.addCustomer(c1);
	Assert.assertNotNull(customerDao.getCustomerById(c1.getId()));
    }
    
    @Test
    public void testUpdateCustomer(){
	customerService.addCustomer(c1);
	c1.setForename("Customer 2");
	customerDao.updateCustomer(c1);
	Assert.assertEquals(customerDao.getCustomerById(c1.getId()).getForename(), c1.getForename());
    }
    
    @Test
    public void testDeleteCustomer(){
	customerDao.addCustomer(c1);
        Assert.assertNotNull(customerDao.getCustomerById(c1.getId()));

        customerDao.deleteCustomer(c1);
        Assert.assertNull(customerDao.getCustomerById(c1.getId()));
    }
    
    @Test
    public void testGetBookingById(){
        customerDao.addCustomer(c1);
        Customer output = customerDao.getCustomerById(c1.getId());
        Assert.assertEquals(output, c1);
    }
}
