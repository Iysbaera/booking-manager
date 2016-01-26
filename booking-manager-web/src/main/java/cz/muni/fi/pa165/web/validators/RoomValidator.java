package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;

/**
 * Created by expres on 12/18/2015.
 */
public class RoomValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return CreateRoomDto.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CreateRoomDto room = (CreateRoomDto) o;
        
        if (room.getRoomType() == null) errors.rejectValue("roomType", null);
        if (room.getHotelId()==null ) errors.rejectValue("hotel", null);
        if (room.getPrice() == null) errors.rejectValue("price", null);
        else if (room.getPrice().compareTo(ZERO) < 0) errors.reject("priceError");
        if (room.getNumber() < 0) errors.rejectValue("number", null);        

    }
}
