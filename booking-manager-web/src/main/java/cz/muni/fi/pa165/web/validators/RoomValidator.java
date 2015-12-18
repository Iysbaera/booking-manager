package cz.muni.fi.pa165.web.validators;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

    }
}
