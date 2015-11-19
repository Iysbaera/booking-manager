package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Room;

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
    public void addRoom(Room room);

    /**
     * (D)elete already added (persisted) room taken as parameter.
     *
     * @throws IllegalArgumentException if the room is null
     * @param room the room to be updated
     */
    public void deleteRoom(Room room);

    /**
     * (U)pdates already added (persisted) room taken as parameter.
     *
     * @throws IllegalArgumentException if the room is null
     * @param room the room to be updated
     */
    public void updateRoom(Room room);

    /**
     * (R)etrieve a specific room, which has een already created.
     *
     * @throws IllegalArgumentException if the id is null
     * @param id the id of the room to be retrieved
     */
    public Room getRoomById(Long id);

}
