package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.CustomerDto;

import java.util.Collection;

/**
 */
public interface CustomerFacade {
    CustomerDto getCustomerById(Long id);
    Collection<CustomerDto> getAllCustomers();
}
