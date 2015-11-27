package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.entity.Hotel;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Jana Cechackova
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerById(Long id);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getAllBookedCustomers(Date date, Hotel hotel);
}
