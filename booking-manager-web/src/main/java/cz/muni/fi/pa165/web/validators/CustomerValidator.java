package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;


/**
 * @author Jana Cechackova
 */
public class CustomerValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
	
        CreateCustomerDto customer = (CreateCustomerDto) target;
        if ((customer.getPassword()== null)|| (
                customer.getPassword().trim().isEmpty())) errors.rejectValue("password", null);
        if (!isEmailValid(customer.getEmail())) errors.rejectValue("email", null);
        if ((customer.getSurname() == null)|| (
            customer.getSurname().trim().isEmpty())) errors.rejectValue("surname", null);
        if ((customer.getForename() == null)|| (
                customer.getForename().trim().isEmpty())) errors.rejectValue("forename", null);
    }

    public boolean isEmailValid(String address){
        boolean allowLocal = true;
        return EmailValidator.getInstance(allowLocal).isValid(address);    
    }
    
    @Override
    public boolean supports(Class<?> type) {
	return CreateCustomerDto.class.isAssignableFrom(type);
    }
}