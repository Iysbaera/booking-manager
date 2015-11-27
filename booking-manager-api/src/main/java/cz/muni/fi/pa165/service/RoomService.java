package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Room;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Jana Cechackova
 */
public interface RoomService {
    void addRoom(Room room);
    void deleteRoom(Room room);
    void updateRoom(Room room);
    Room getRoomDtoById(Long id);
    Collection<Room> getAllRooms();
    void changeAllPrices(BigDecimal price);
}
