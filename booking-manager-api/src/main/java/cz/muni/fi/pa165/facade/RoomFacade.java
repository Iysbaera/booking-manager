package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.RoomDto;

import java.util.Collection;

/**
 * Facade for room operations.
 *
 * @author Ivo Hradek
 */
public interface RoomFacade {
    /**
     * Get all rooms in system. Meaning all rooms of all hotels
     *
     * @return Collection of rooms as data transfer objects.
     */
    Collection<RoomDto> getAllRooms();

    /**
     * Get room by its id.
     *
     * @param id of specific room.
     * @return Room as data transfer object.
     */
    RoomDto getRoomById(Long id);
}
