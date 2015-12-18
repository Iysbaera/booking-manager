package cz.muni.fi.pa165.rest.controllers;

import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.facade.CustomerFacade;
import cz.muni.fi.pa165.rest.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerRestController {

    final static Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping(value = "", method = GET)
    @ResponseBody
    public List<CustomerDto> getAll() {
        return (List) customerFacade.getAllCustomers();
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public CustomerDto get(@PathVariable(value = "id") Long id) {
        CustomerDto customer = customerFacade.getCustomerById(id);
        if (null == customer) {
            throw new ResourceNotFoundException();
        }

        return customer;
    }

    @RequestMapping(value="create", method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CustomerDto customer) {
        customerFacade.updateCustomer(customer);
    }

    @RequestMapping(value = "/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody CustomerDto customer) {
        customerFacade.updateCustomer(customer);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        CustomerDto customer = customerFacade.getCustomerById(id);

        if (null == customer) {
            throw new ResourceNotFoundException();
        }
        customerFacade.deleteCustomer(id);
    }
}
