package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Jana Cechackova
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
	return customer;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerDao.findAllCustomers();
    }

    @Override
    public Collection<Customer> getAllBookedCustomers(Date date, Hotel hotel) {
        Collection<Customer> result = new ArrayList<Customer>();
        for (Customer c : customerDao.findAllCustomers()) {
            for (Booking b : c.getBookings()) {

                if ((date.after(b.getCheckIn()) && date.before(b.getCheckOut())) ||
                        (date.equals(b.getCheckIn())) ||
                        (date.equals(b.getCheckOut()))) {

                    if (b.getRoom().getHotel().equals(hotel)) {
                        result.add(c);
                    }
                }
            }
        }

        return result;
    }
}
