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
               
        if((booking.getCheckIn()!= null)&&(booking.getCheckOut()!=null)){
            
            if ((booking.getCheckIn().after(booking.getCheckOut())) 
                || (booking.getCheckIn().equals(booking.getCheckOut()))
                    || (booking.getCheckIn().before(new Date()))
                        || (booking.getCheckOut().before(new Date())))
                                
            errors.reject("duration");
        } 
        
        if (booking.getCustomerId() == null)  errors.rejectValue("customer", null);
                
        if (booking.getRoomId() == null)  errors.rejectValue("room", null);
        
        if (booking.getCheckOut() == null) errors.rejectValue("checkOut", null);
        
        if (booking.getCheckIn() == null) errors.rejectValue("checkIn", null);
      
    }
        
    }
       
        
//       Long zero = 0L;
//        Long roomId = booking.getRoomId();
//        if (roomId < zero) {
//            errors.reject("Invalid room number");
//        }
    

