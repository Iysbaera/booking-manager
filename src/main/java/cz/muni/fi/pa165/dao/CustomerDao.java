package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Customer;

/**
 * @author Jana Cechackova
 */
public interface CustomerDao {
    
    public void addCustomer(Customer customer);
    
    public void updateCustomer(Customer customer);
    
    public void deleteCustomer(Customer customer);
    
    public Customer getCustomerById(Long Id);    
    
}
