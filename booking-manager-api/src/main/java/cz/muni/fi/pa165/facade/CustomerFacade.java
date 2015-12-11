package cz.muni.fi.pa165.facade;

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
}
