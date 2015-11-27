package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Hotel;

import java.util.Collection;

/**
 */
public interface RoomFacade {
    Collection<RoomDto> getAllRooms();
    RoomDto getRoomById(Long id);
}
