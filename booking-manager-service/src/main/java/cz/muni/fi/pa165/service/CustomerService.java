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
    
    /**
     * Method to add a new customer
     * 
     * @param customer	    customer to be added 
     */
    void addCustomer(Customer customer);
    
    /**
     * Method to delete a specific customer
     * 
     * @param customer	    customer to be deleted
     */
    void deleteCustomer(Customer customer);
    
    /**
     * Method to update a specific customer
     * 
     * @param customer	    customer to be updated
     */
    void updateCustomer(Customer customer);
    
    /**
     * Method to get a customer by his ID.
     * 
     * @param id
     * @return customer with matching ID
     */
    Customer getCustomerById(Long id);
    
    /**
     * Method to get all customers.
     * 
     * @return a new Collection of all customers.
     */
    Collection<Customer> getAllCustomers();
    
    /**
     * Method to get all customers that have at least one booking on a certain date. 
     * 
     * @param date	date, on which do desired customers have at least one booking
     * @param hotel	a specific hotel, where all booked customers must have a booking
     * @return a new Collection of all booked customers, for a specific day and specific hotel
     */
    Collection<Customer> getAllBookedCustomers(Date date, Hotel hotel);
}