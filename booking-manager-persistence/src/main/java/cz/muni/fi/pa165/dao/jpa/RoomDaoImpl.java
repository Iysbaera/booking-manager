package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

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

    @Override
    public Collection<Room> findFreeRooms(Hotel hotel, Date fromDate, Date uptoDate) {
        if (null == hotel) {
            throw new IllegalArgumentException("hotel is null");
        }
        if (null == fromDate) {
            throw new IllegalArgumentException("from date is null");
        }
        if (null == uptoDate) {
            throw new IllegalArgumentException("upto date is null");
        }
        Query query = getEntityManager().createQuery(
                "select r from Room r where r not in " +
                        "(select b.room from Booking b where " +
                        "(b.checkIn >= :fromDate and b.checkOut <= :uptoDate) or " +
                        "(b.checkIn >= :fromDate and b.checkOut <= :uptoDate) or " +
                        "(b.checkIn <= :fromDate and b.checkOut >= :uptoDate)" +
                        "and r.hotel = :hotelId)",Room.class)
                .setParameter("fromDate", fromDate, TemporalType.DATE)
                .setParameter("uptoDate", uptoDate, TemporalType.DATE)
                .setParameter("hotelId", hotel.getId());
        return Collections.unmodifiableCollection(query.getResultList());
    }

    @Override
    public Collection<Room> findAllRooms() {
        return getEntityManager().createQuery("select r from Room r", Room.class)
                .getResultList();
    }
}
