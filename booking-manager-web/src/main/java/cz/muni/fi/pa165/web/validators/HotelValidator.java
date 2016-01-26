package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateHotelDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Ivo Hradek
 */
public class HotelValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        CreateHotelDto hotel = (CreateHotelDto) target;
        if (null == hotel.getName() || hotel.getName().trim().isEmpty()) errors.rejectValue("name", null);

    }

    @Override
    public boolean supports(Class<?> type) {
        return CreateHotelDto.class.isAssignableFrom(type);
    }
}