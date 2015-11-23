package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Hotel;
import org.springframework.stereotype.Repository;

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
    public Hotel getHotelById(Long id){
        if (null == id) {
            throw new IllegalArgumentException("id is null");
        }
        return getEntityManager().find(Hotel.class, id);
    }

    @Override
    public Collection<Hotel> findAllHotels() {
        return getEntityManager().createQuery("select h from Hotel h", Hotel.class)
                                 .getResultList();
    }
}
