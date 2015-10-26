/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.entity.Customer;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CustomerDaoTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private CustomerDao customerDao;    
    
    private Customer customer1;  
    
    @Before
    public void setUp() {
        customer1 = new Customer();
        customer1.setForename("Jan");
        customer1.setSurname("Janosik");        
    }

    /**
     * Test of addCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testAddCustomer() {
        customerDao.addCustomer(customer1);
        Assert.assertEquals(customerDao.getCustomerById(customer1.getId()).getForename(),
                            "Jan");
    }

    /**
     * Test of updateCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testUpdateCustomer() {
        customerDao.addCustomer(customer1);
        Assert.assertNotNull(customerDao.getCustomerById(customer1.getId()));
        
        customer1.setForename("Janko");
        customerDao.updateCustomer(customer1);
        Assert.assertEquals(customerDao.getCustomerById(customer1.getId()), 
                            "Janko");
    }

    /**
     * Test of deleteCustomer method, of class CustomerDaoImpl.
     */
    @Test
    public void testDeleteCustomer() {
        customerDao.addCustomer(customer1);
        Assert.assertNotNull(customerDao.getCustomerById(customer1.getId()));
        
        customerDao.deleteCustomer(customer1);
        Assert.assertNull(customerDao.getCustomerById(customer1.getId()));
    }

    /**
     * Test of getCustomerById method, of class CustomerDaoImpl.
     */
    @Test
    public void testGetCustomerById() {
        customerDao.addCustomer(customer1);        
        Customer result = customerDao.getCustomerById(customer1.getId());
        Assert.assertEquals(customer1.getForename(), result.getForename());
    }
    
}
