package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Jana Cechackova
 */
public class CustomerValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
	
        CreateCustomerDto customer = (CreateCustomerDto) target;
        if ((customer.getForename() == null)|| (
                customer.getForename().trim().isEmpty())) errors.reject("NULL");
	if ((customer.getSurname() == null)|| (
            customer.getSurname().trim().isEmpty())) errors.reject("NULL");
	if (customer.getEmail() == null ||
            customer.getEmail().trim().isEmpty()) errors.reject("Invalid email");
    }

    @Override
    public boolean supports(Class<?> type) {
	return CreateCustomerDto.class.isAssignableFrom(type);
    }
}