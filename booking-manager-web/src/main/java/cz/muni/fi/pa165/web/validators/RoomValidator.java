package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

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
        if (room.getHotelId()==null ) errors.reject("room must be assigned to hotel");
        if (room.getRoomType() == null) errors.reject("room type not selected");
        if (room.getPrice().compareTo(BigDecimal.ZERO)<0) errors.reject("price cant be negative number");
        if (room.getNumber() < 0) errors.reject("Room number cant be negative number");
        if (room.getHotelId() < 0) errors.reject("Incorrect Hotel");
        

    }
}
