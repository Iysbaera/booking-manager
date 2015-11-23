package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;
import java.util.Date;

/**
 * Data Access Object for <tt>Room</tt> entity. It provides basic CRUD operations.
 *
 * @see Room
 * @author Jana Cechackova
 */
public interface RoomDao {

    /**
     * (C)reates the room, meaning persist it into the database.
     *
     * @throws IllegalArgumentException if the room is null
     * @param room the room to be added
     */
    void addRoom(Room room);

    /**
     * (D)elete already added (persisted) room taken as parameter.
     *
     * @throws IllegalArgumentException if the room is null
     * @param room the room to be updated
     */
    void deleteRoom(Room room);

    /**
     * (U)pdates already added (persisted) room taken as parameter.
     *
     * @throws IllegalArgumentException if the room is null
     * @param room the room to be updated
     */
    void updateRoom(Room room);

    /**
     * (R)etrieve a specific room, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the room to be retrieved
     * @return room if was found otherwise null
     */
    Room getRoomById(Long id);

    /**
     * (R)etrieve all free rooms in specific hotel in certain date range.
     *
     * @throws IllegalArgumentException if some argument is null
     * @param hotel - hotel in which is room will be searched for
     * @param fromDate - from date which should be room available
     * @param uptoDate - to date which should be room available
     * @return Collection of all free rooms or empty collection
     *         if there are no available rooms
     */
    Collection<Room> findFreeRooms(Hotel hotel, Date fromDate, Date uptoDate);
}
