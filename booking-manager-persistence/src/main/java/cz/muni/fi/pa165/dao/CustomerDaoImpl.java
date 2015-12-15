package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.dao.CustomerDao;
import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.Collection;

/**
 * @author Jana Cechackova
 */
@Repository
public class CustomerDaoImpl extends DAOBase implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null.");
        }
        try {
            getEntityManager().persist(customer);
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null.");
        }
        try {
            getEntityManager().merge(customer);
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try {
            Customer toBeRemoved = getEntityManager().merge(customer);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        } catch (Exception ex) {
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        if (null == id) {
            throw new IllegalArgumentException("id is null");
        }
        return getEntityManager().find(Customer.class, id);
    }

    @Override
    public Collection<Customer> findAllCustomers() {
        return getEntityManager().createQuery("from Customer").getResultList();
    }
}
