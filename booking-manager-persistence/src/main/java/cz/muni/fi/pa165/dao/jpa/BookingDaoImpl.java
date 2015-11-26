package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.dao.DAOBase;
import cz.muni.fi.pa165.entity.Booking;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import java.util.Collection;

/**
 *
 * @author Jana Cechackova
 */
@Repository
public class BookingDaoImpl extends DAOBase implements BookingDao {

    @Override
    public void addBooking(Booking booking) {
	if (booking == null){
	    throw new IllegalArgumentException("Booking is null.");
	}
	try {
	    getEntityManager().persist(booking);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n"+ ex.getMessage(), ex);
	}
    }

    @Override
    public void updateBooking(Booking booking) {
	if (booking == null){
	    throw new IllegalArgumentException("Booking is null.");
	}
	try {
	    getEntityManager().merge(booking);
	}
	catch (Exception ex){
	    throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
	}
    }

    @Override
    public void deleteBooking(Booking booking){
	try {
            Booking toBeRemoved = getEntityManager().merge(booking);
            if (toBeRemoved != null) {
                getEntityManager().remove(toBeRemoved);
            }
        }
        catch(Exception ex){
            throw new PersistenceException("Transaction failed.\n" + ex.getMessage(), ex);
        }
    }

    @Override
    public Booking getBookingById(Long id){
        if (null == id) {
            throw new IllegalArgumentException("id is null");
        }
        return getEntityManager().find(Booking.class, id);
    }

    @Override
    public Collection<Booking> findAllBookings() {
        return getEntityManager().createQuery("from Booking b").getResultList();
    }
}
