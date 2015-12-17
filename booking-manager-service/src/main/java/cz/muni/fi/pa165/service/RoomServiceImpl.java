package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author Jana Cechackova
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public Room addRoom(Room room) {
        roomDao.addRoom(room);
	return room;
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
        System.out.println(roomDao.findAllRooms());
        for (Room r : roomDao.findAllRooms()) {
            BigDecimal newPrice = r.getPrice().add(price);
            r.setPrice(newPrice);
        }
    }

    @Override
    public void changePrice(BigDecimal price_bd, Long id) {
        Room room = roomDao.getRoomById(id);
        if(room != null){
            room.setPrice(price_bd);
        }
    }
}
