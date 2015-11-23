package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Customer;

/**
 * Data Access Object for <tt>Customer</tt> entity. It provides basic CRUD operations.
 *
 * @see Customer
 * @author Jana Cechackova
 */
public interface CustomerDao {

    /**
     * (C)reates the customer, meaning persist it into the database.
     *
     * @throws IllegalArgumentException if the customer is null
     * @param customer the customer to be added
     */
    void addCustomer(Customer customer);

    /**
     * (U)pdates already added (persisted) customer taken as parameter.
     *
     * @throws IllegalArgumentException if the customer is null
     * @param customer the customer to be updated
     */
    void updateCustomer(Customer customer);

    /**
     * (D)elete already added (persisted) customer taken as parameter.
     *
     * @throws IllegalArgumentException if the customer is null
     * @param customer the customer to be updated
     */
    void deleteCustomer(Customer customer);

    /**
     * (R)etrieve a specific customer, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the customer to be retrieved
     * @return found customer, otherwise null
     */
    Customer getCustomerById(Long id);

}
