package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Room;
import java.math.BigDecimal;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jana Cechackova
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room);
    }

    @Override
    public void updateRoom(Room room) {
        roomDao.updateRoom(room);
    }

    @Override
    public Room getRoomDtoById(Long id) {
        return roomDao.getRoomById(id);
    }

    @Override
    public Collection<Room> getAllRooms() {
        return roomDao.findAllRooms();
    }

    @Override
    public void changeAllPrices(BigDecimal price) {
        for (Room r : roomDao.findAllRooms()) {
            r.setPrice(r.getPrice().add(price));
        }
    }
}
