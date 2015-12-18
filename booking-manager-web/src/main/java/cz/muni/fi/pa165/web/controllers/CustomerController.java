package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.dto.CustomerDto;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.facade.CustomerFacade;
import cz.muni.fi.pa165.web.validators.CustomerValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    
     final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof CreateCustomerDto) {
            binder.addValidators(new CustomerValidator());
        }
    }
    
    @ModelAttribute("customer")
    public CreateCustomerDto getCustomer(){
	return new CreateCustomerDto();
    }
    
     
    @Autowired
    private CustomerFacade customerFacade;

    /**
     * Method to list all customers stored in a database.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String customers(Model model) {
        log.info("customers = {}", customerFacade.getAllCustomers());
        Collection<CustomerDto> test = new ArrayList<CustomerDto>();
        test = customerFacade.getAllCustomers();
	model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customer/list";
    }
    /**
     * Method to run a new page with a form for new customers.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("create new");
        model.addAttribute("customer", new CreateCustomerDto());
        return "customer/create";
    }
    
    /**
     * Method to delete a customer. Customer's ID is used to find him in a database.
     * FIX ME : Exception - ID is null.
     * 
     * @param id
     * @param locale
     * @param uriBuilder
     * @param redirectAttributes
     * @return 
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Locale locale, UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        log.debug("delete({})", id);
        customerFacade.deleteCustomer(id);
	redirectAttributes.addFlashAttribute("alert_success", "User was successfully deleted.");
	
        return "redirect:" + uriBuilder.path("/customer/list").build();
    }
    /**
     * Method to create new customer. 
     * 
     * Parameter's order has to be exactly like this! @ModelAttribute(name_of_the_entity) ..., BindingResult, and the rest
     * 
     * @param customer
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return 
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("customer") CreateCustomerDto customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {

        for (Object object : bindingResult.getAllErrors()) {
            if(object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;

                System.out.println(fieldError.getCode());
            }

            if(object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;

                System.out.println(objectError.getCode());
            }
        }
	  if (bindingResult.hasErrors()){
	      
		redirectAttributes.addFlashAttribute("alert_failure", "Forename or surname was not filled!");
	       return "redirect:" + uriBuilder.path("/customer/create").build();
	   }
	  

	    customerFacade.createCustomer(customer);
	    redirectAttributes.addFlashAttribute("alert_success", "User was successfully created.");
	    return "redirect:" + uriBuilder.path("/customer/list").build();
	
    }
    /**
     * Method to update a form = fill with user's data.
     * 
     * @param id
     * @param model
     * @return 
     */
     @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit_form(@PathVariable long id, Model model) {

        model.addAttribute("customer", customerFacade.getCustomerById(id));
        log.debug("update_form(model={})", model);
        return "customer/edit";
    }
    
    /**
     * Method to update a customer in a database.
     * 
     * @param id
     * @param customer
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return 
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @Valid @ModelAttribute("customer") CreateCustomerDto customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {
        
	  if (bindingResult.hasErrors()){
	       redirectAttributes.addFlashAttribute("alert_failure", "Forename or surname was not filled!");
	       return "redirect:" + uriBuilder.path("/customer/edit/"+id).build();
	   }
	    	  
	  CustomerDto updatedCustomer = customerFacade.getCustomerById(id);
	  updatedCustomer.setForename(customer.getForename());
	  updatedCustomer.setSurname(customer.getSurname());
	  
	customerFacade.updateCustomer(updatedCustomer);
	redirectAttributes.addFlashAttribute("alert_success", "User was successfully updated.");
        
	return "redirect:" + uriBuilder.path("/customer/list").build();
	
    }
    
 }
