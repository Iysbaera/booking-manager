package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Customer;

import java.util.Collection;

/**
 * Data Access Object for <tt>Customer</tt> entity.
 * It provides basic CRUD operations.
 *
 * @author Jana Cechackova
 * @see Customer
 */
public interface CustomerDao {

    /**
     * (C)reates the customer, meaning persist it into the database.
     *
     * @param customer the customer to be added
     * @throws IllegalArgumentException if the customer is null
     */
    void addCustomer(Customer customer);

    /**
     * (U)pdates already added (persisted) customer taken as parameter.
     *
     * @param customer the customer to be updated
     * @throws IllegalArgumentException if the customer is null
     */
    void updateCustomer(Customer customer);

    /**
     * (D)elete already added (persisted) customer taken as parameter.
     *
     * @param customer the customer to be updated
     * @throws IllegalArgumentException if the customer is null
     */
    void deleteCustomer(Customer customer);

    /**
     * (R)etrieve a specific customer, which has been already created.
     *
     * @param id the id of the customer to be retrieved
     * @return found customer, otherwise null
     * @throws IllegalArgumentException if the id is null
     */
    Customer getCustomerById(Long id);

    /**
     * (R)etrieve a all customers.
     *
     * @return Collection of found customers, if there are no customers
     * empty collection will be returned
     */
    Collection<Customer> findAllCustomers();
}
