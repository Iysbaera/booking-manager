package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;

import java.math.BigDecimal;
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
    /**
     * Delete customer depending on his id.
     *
     * @param id of a customer to be deleted.
     */
    void deleteRoom(Long id);

    /**
     * Create new customer.
     *
     * @param roomDto
     * @return id of new customer
     */
    Long createRoom(CreateRoomDto roomDto);

    void changePrice(Long id, BigDecimal price_bd);
}
