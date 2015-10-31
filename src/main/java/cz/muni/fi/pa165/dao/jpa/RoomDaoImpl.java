package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

/**
 *
 *
 * @author Jana Cechackova
 */
@Repository
public class RoomDaoImpl extends DAOBase implements RoomDao {

    @Override
    public void addRoom(Room room) {
	if (room == null){
	    throw new IllegalArgumentException("Room is null.");
	}
	try {
	    getEntityManager().persist(room);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n"+ ex.getMessage(), ex);
	}
    }

    @Override
    public void updateRoom(Room room) {
	if (room == null){
	    throw new IllegalArgumentException("Room is null.");
	}
	try {
	    getEntityManager().merge(room);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
	}
    }

    @Override
    public void deleteRoom(Room room){
        if (room == null){
            throw new IllegalArgumentException("Room is null.");
        }
        try {
            Room toBeRemoved = getEntityManager().merge(room);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public Room getRoomById(Long id) {
        if (null == id) {
            throw new IllegalArgumentException("Id is null");
        }
        return getEntityManager().find(Room.class, id);
    }
}
