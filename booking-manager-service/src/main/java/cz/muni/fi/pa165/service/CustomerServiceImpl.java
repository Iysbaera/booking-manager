package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.entity.Customer;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jana Cechackova
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    
    CustomerDao customerDao;
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void addCustomer(CustomerDto customerDto) {
	
	Customer customer;
	
	customer = mapper.map(customerDto, Customer.class);
//	customerDto.setId(customer.getId());   not included because the method is not implemented yet
	customerDao.addCustomer(customer);    
    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {
	
	Customer customer;
	
	customer = mapper.map(customerDto, Customer.class);
	customerDao.deleteCustomer(customer);    
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
	
	Customer customer;
    
	customer = mapper.map(customerDto, Customer.class);
	customerDao.updateCustomer(customer);
    }

    @Override
    public CustomerDto getCustomerDtoById(Long id) {
	
	//not implemented yet
	
	return null;    
    } 
}
