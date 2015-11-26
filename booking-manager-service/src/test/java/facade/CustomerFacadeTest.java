package facade;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.facade.CustomerFacade;
import cz.muni.fi.pa165.service.CustomerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

@ContextConfiguration("classpath:application-context-service-test.xml")
public class CustomerFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    @Mock
    private CustomerDao customerDao;

    @Autowired
    @InjectMocks
    private CustomerService customerService;

    @Autowired
    private CustomerFacade customerFacade;

    private Customer c1;

    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void beforeMethod() throws ParseException {
        c1 = new Customer();
        c1.setForename("Test forename 1");
        c1.setSurname("Test surname 1");
    }

    @Test
    public void testGetCustomerId() {
        /* Prepare test */
        Long testId = 1L;
        when(customerDao.getCustomerById(testId)).thenReturn(c1);

        /* Retrieve */
        CustomerDto cdto = customerFacade.getCustomerById(testId);

        /* Same customer? Same forename and surname */
        Assert.assertEquals(cdto.getForename(), cdto.getForename(), "Customer's forename");
        Assert.assertEquals(cdto.getSurname(), cdto.getSurname(), "Customer's surname");
    }

    @Test
    public void testGetAllCustomers() {
        /* Prepare mock */
        when(customerDao.findAllCustomers()).thenReturn(new ArrayList<Customer>() {
            { add(c1); }
        });

        /* Is there exactly one customers? */
        Collection<CustomerDto> dtos = customerFacade.getAllCustomers();
        Assert.assertTrue(dtos.size() == 1, "Number of customers");

        /* Same customer? Same forename and surname */
        CustomerDto actual = ((List<CustomerDto>) dtos).get(0);
        Assert.assertEquals(actual.getForename(), c1.getForename(), "Customer's forename");
        Assert.assertEquals(actual.getSurname(), c1.getSurname(), "Customer's surname");
    }
}
