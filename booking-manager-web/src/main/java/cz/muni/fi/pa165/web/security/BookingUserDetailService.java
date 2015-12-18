package cz.muni.fi.pa165.web.security;

import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ivo Hradek
 */
@Component
public class BookingUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerFacade customerFacade;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomerDto customer = customerFacade.getCustomerByEmail(email);
        if (null == customer) {
            throw new UsernameNotFoundException(email);
        }

        return new BookingUserDetailAdapter(customer);
    }
}
