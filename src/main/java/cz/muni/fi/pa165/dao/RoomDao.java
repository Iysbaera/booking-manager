package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Room;

/**
 * @author Jana Cechackova
 */
public interface RoomDao {
    
    public void addRoom(Room room);
    
    public void updateRoom(Room room);
    
    public void deleteRoom(Room room);
    
    public Room getRoomById(Long Id);    
    
}
