package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;

import java.util.Collection;
import java.util.Date;

/**
 * Data Access Object for <tt>Room</tt> entity.
 * It provides basic CRUD operations.
 *
 * @author Jana Cechackova
 * @see Room
 */
public interface RoomDao {

    /**
     * (C)reates the room, meaning persist it into the database.
     *
     * @param room the room to be added
     * @throws IllegalArgumentException if the room is null
     */
    void addRoom(Room room);

    /**
     * (D)elete already added (persisted) room taken as parameter.
     *
     * @param room the room to be updated
     * @throws IllegalArgumentException if the room is null
     */
    void deleteRoom(Room room);

    /**
     * (U)pdates already added (persisted) room taken as parameter.
     *
     * @param room the room to be updated
     * @throws IllegalArgumentException if the room is null
     */
    void updateRoom(Room room);

    /**
     * (R)etrieve a specific room, which has een already created.
     *
     * @param id the id of the room to be retrieved
     * @return room if was found otherwise null
     * @throws IllegalArgumentException if the id is null
     */
    Room getRoomById(Long id);

    /**
     * (R)etrieve all free rooms in specific hotel in certain date range.
     *
     * @param hotel    - hotel in which is room will be searched for
     * @param fromDate - from date which should be room available
     * @param uptoDate - to date which should be room available
     * @return Collection of all free rooms or empty collection
     * if there are no available rooms
     * @throws IllegalArgumentException if some argument is null
     */
    Collection<Room> findFreeRooms(Hotel hotel, Date fromDate, Date uptoDate);

    /**
     * (R)etrieve a all rooms, which have been already created.
     *
     * @return Collection of found rooms, if there are no rooms
     * empty collection will be returned
     */
    Collection<Room> findAllRooms();
}
