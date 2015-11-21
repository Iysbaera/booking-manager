package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dto.CustomerDto;

/**
 *
 * @author Jana Cechackova
 */
public interface CustomerService {
    
    public void addCustomer(CustomerDto customerDto);
    public void deleteCustomer(CustomerDto customerDto);
    public void updateCustomer(CustomerDto customerDto);
    public CustomerDto getCustomerDtoById(Long id);
}
