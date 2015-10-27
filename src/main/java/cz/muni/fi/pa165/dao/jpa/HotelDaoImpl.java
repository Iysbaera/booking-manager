package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.Collection;

/**
 *
 * @author Jana Cechackova
 */
@Repository
public class HotelDaoImpl extends DAOBase implements HotelDao {

    @Override
    public void addHotel(Hotel hotel) {
	if (hotel == null){
	    throw new IllegalArgumentException("Hotel is null.");
	}
	try {
	    getEntityManager().persist(hotel);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n"+ ex.getMessage(), ex);
	}
    }

    @Override
    public void updateHotel(Hotel hotel) {
	if (hotel == null){
	    throw new IllegalArgumentException("Hotel is null.");
	}
	try {
	    getEntityManager().merge(hotel);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
	}
    }

    @Override
    public void deleteHotel(Hotel hotel){
	try {
            Hotel toBeRemoved = getEntityManager().merge(hotel);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public Hotel getHotelById(Long Id){
        return getEntityManager().find(Hotel.class, Id);
    }

    @Override
    public Collection<Hotel> findAllHotels() {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Room> findFreeRooms() {
        throw new NotImplementedException();
    }
}
