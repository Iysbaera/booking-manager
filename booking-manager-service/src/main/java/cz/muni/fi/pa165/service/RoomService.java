package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Room;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author Jana Cechackova
 */

public interface RoomService {

    /**
     * Method to add a new room.
     *
     * @param room new room to be added
     * @return added room
     */
    Room addRoom(Room room);

    /**
     * Method to delete a specific room.
     *
     * @param room a specific room to be deleted
     */
    void deleteRoom(Room room);

    /**
     * Method to update a room meaning update its parameters.
     *
     * @param room room to be updated
     */
    void updateRoom(Room room);

    /**
     * Method to get a room by its ID.
     *
     * @param id ID of a room
     * @return room with a matching ID
     */
    Room getRoomDtoById(Long id);

    /**
     * Method to get all rooms.
     *
     * @return collection of all rooms.
     */
    Collection<Room> getAllRooms();

    /**
     * Method to change prices of all rooms
     *
     * @param price number which will be added to prices of all rooms
     */
    void changeAllPrices(BigDecimal price);

    void changePrice(BigDecimal price_bd, Long id);
}