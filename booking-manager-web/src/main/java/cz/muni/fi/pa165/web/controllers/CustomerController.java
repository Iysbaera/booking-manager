package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.facade.CustomerFacade;
import java.util.Locale;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jana Cechackova
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
     final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String customers(Model model) {
        log.info("customers = {}", customerFacade.getAllCustomers());
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customer/list";
    }
    
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        CustomerDto customer = customerFacade.getCustomerById(id);
        customerFacade.deleteCustomer(customer.getId());
        
	
        return "redirect:" + uriBuilder.path("/customer/list").build();
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("customer") CustomerDto customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        log.debug("update(locale={}, customer={})", locale, customer);
        log.debug("--------------------------------------------------------");
        log.debug("customerDTO{" + "id=" + customer.getId() + ", Forename=" + customer.getForename() 
                + ", Surname=" + customer.getSurname() + '}');
        if (bindingResult.hasErrors()) {
            log.debug("binding errors");
            for (ObjectError ge : bindingResult.getGlobalErrors()) {
                log.debug("ObjectError: {}", ge);
            }
            for (FieldError fe : bindingResult.getFieldErrors()) {
                log.debug("FieldError: {}", fe);
            }
            return customer.getId()==null?"customer/list":"customer/edit";
        }
        if (customer.getId() == null) {
            customerFacade.addcustomer(customer);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("customer.add.message", new Object[]{customer.getForename(), customer.getSurname()}, locale)
            );
        } else {
            customerFacade.updateCustomer(customer);
            redirectAttributes.addFlashAttribute(
                    "message",
                    messageSource.getMessage("customer.updated.message", new Object[]{customer.getForename(), customer.getSurname()}, locale)
            );
        }
        return "redirect:" + uriBuilder.path("/customer/list").build();
    }
    
    
}
