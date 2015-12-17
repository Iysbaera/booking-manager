package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.dto.CustomerDto;

import java.util.Collection;

/**
 * Facade for customer operations.
 *
 * @author Ivo Hradek
 */
public interface CustomerFacade {
    /**
     * Find customer by his id.
     *
     * @param id of a customer to be found
     * @return Customer DTO. If there is no customer for id then null.
     */
    CustomerDto getCustomerById(Long id);

    /**
     * Get all customers.
     *
     * @return Collection of customers. If there are no customers
     * then empty collection will be returned.
     */
    Collection<CustomerDto> getAllCustomers();

    /**
     * Delete customer depending on his id.
     *
     * @param id of a customer to be deleted.
     */
    void deleteCustomer(Long id);

    /**
     * Create new customer.
     *
     * @param customerDto
     * @return id of new customer
     */
    Long createCustomer(CreateCustomerDto customerDto);

    /**
     * Update a customer.
     *
     * @param customerDto
     * @return id of updated customer
     */
    Long updateCustomer(CustomerDto customerDto);

    /**
     * Find customer by his email. If there are no customer
     * with such an email, null will be returned.
     *
     * @param email
     * @return Customer DTO. If there is no customer
     *         for specified email then null.
     */
    CustomerDto getCustomerByEmail(String email);
}
