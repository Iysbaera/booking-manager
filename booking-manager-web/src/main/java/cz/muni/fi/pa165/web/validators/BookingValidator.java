package cz.muni.fi.pa165.web.validators;

import java.util.Date;
import cz.muni.fi.pa165.dto.CreateBookingDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Juraj Bielik
 */
public class BookingValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return CreateBookingDto.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        CreateBookingDto booking = (CreateBookingDto) target;
        
        if ((booking.getCheckIn() == null) || (booking.getCheckOut() == null)) {
            errors.reject("Date is null.");
        }
        
        if (booking.getRoomId() == null) {
            errors.reject("Room id is null.");
        }
        
        if (booking.getCustomerId() == null){
            errors.reject("Customer id is null.");
        }
        if (booking.getCheckIn().after(booking.getCheckOut())){
            errors.reject("Invalid check in date.");
        }
        if (booking.getCheckIn().equals(booking.getCheckOut())) {
            errors.reject("Invalid check in date.");            
        }
        
        if (booking.getCheckIn().before(new Date())) {
            errors.reject("Invalid check in date");
        }
        
        if (booking.getCheckOut().before(new Date())) {
            errors.reject("Invalid checkout date.");
        }
       Long zero = 0L;
        Long roomId = booking.getRoomId();
        if (roomId < zero) {
            errors.reject("Invalid room number");
        }
    }
    
}
