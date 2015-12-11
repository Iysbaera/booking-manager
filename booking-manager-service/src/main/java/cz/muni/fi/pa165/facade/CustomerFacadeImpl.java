package cz.muni.fi.pa165.facade;


import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.service.CustomerService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link cz.muni.fi.pa165.facade.CustomerFacade} interface
 *
 * @author Ivo Hradek
 * @see cz.muni.fi.pa165.facade.CustomerFacade
 */
@Transactional
@Service("customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {
    @Autowired
    CustomerService customerService;

    @Autowired
    Mapper mapper;

    @Override
    public Collection<CustomerDto> getAllCustomers() {
        return (Collection) ((List) customerService.getAllCustomers()).stream()
                .map(b -> mapper.map(b, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return mapper.map(customerService.getCustomerById(id), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerService.deleteCustomer(customerService.getCustomerById(id));
    }
}
