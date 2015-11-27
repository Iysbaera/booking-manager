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
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Jana Cechackova
 */

@ContextConfiguration(locations = {"classpath:application-context-service-test.xml"})
public class CustomerServiceImplTest extends AbstractTransactionalTestNGSpringContextTests{
    
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
	
	when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
	Assert.assertNotNull(customerService.getCustomerById(c1.getId()));
    }
    
    @Test
    public void testUpdateCustomer(){
	customerService.addCustomer(c1);
	c1.setForename("Customer 2");
	customerService.updateCustomer(c1);
	
	when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
	Assert.assertEquals(customerService.getCustomerById(c1.getId()).getForename(), c1.getForename());
    }
    
    @Test
    public void testDeleteCustomer(){
	customerService.addCustomer(c1);
	
	when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
        Assert.assertNotNull(customerService.getCustomerById(c1.getId()));

        customerService.deleteCustomer(c1);
	when(customerDao.getCustomerById(c1.getId())).thenReturn(null);
        Assert.assertNull(customerService.getCustomerById(c1.getId()));
    }
    
    @Test
    public void testGetBookingById(){
        customerService.addCustomer(c1);
	
	when(customerDao.getCustomerById(c1.getId())).thenReturn(c1);
        Customer output = customerService.getCustomerById(c1.getId());
	
        Assert.assertEquals(output, c1);
    }
}
