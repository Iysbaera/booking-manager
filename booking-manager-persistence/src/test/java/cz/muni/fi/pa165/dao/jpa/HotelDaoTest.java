package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 *
 * @author Juraj Bielik
 * @author Ivo Hradek
 */
@Transactional
@ContextConfiguration("classpath:application-context-persistence-test.xml")
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class HotelDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private HotelDao hotelDao;

    /* Hotels */
    private Hotel h1;
    private Hotel h2;

    /* Rooms */
    @Mock private Room r1;
    @Mock private Room r2;
    @Mock private Room r3;

    /* Bookings */
    @Mock private Booking b1;
    @Mock private Booking b2;

    @BeforeMethod
    public void setUp() {
        /* Create hotels */
        h1 = new Hotel();
        h2 = new Hotel();

        h1.setName("Hotel 1");
        h2.setName("Hotel 2");
    }

    /*
     * Test of addHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testAddHotel() {
        /* Create mock rooms */
        r1 = Mockito.mock(Room.class);
        r2 = Mockito.mock(Room.class);

        /* Hotel with rooms */
        h1.addRoom(r1);
        h1.addRoom(r2);
        hotelDao.addHotel(h1);

        /* Hotel without rooms */
        hotelDao.addHotel(h2);

        /* Hotels were added */
        Assert.assertNotNull(h1.getId());
        Assert.assertNotNull(h2.getId());

        /* Names weren't modified */
        String h1Name = hotelDao.getHotelById(h1.getId()).getName();
        String h2Name = hotelDao.getHotelById(h2.getId()).getName();
        Assert.assertEquals(h1Name, h1.getName(), "Hotel1 name was malformed");
        Assert.assertEquals(h2Name, h2.getName(), "Hotel2 name was malformed");

        /* Rooms were added too */
        int numberOfRoomsHotel1 =
                hotelDao.getHotelById(h1.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel1, h1.getRooms().size(), "Number of hotel1 rooms are not same");

        int numberOfRoomsHotel2 =
                hotelDao.getHotelById(h2.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel2, h2.getRooms().size(), "Number of hotel2 rooms are not same");

        /* Same rooms were added */
        for (Room r : h1.getRooms()) {
            Assert.assertNotNull(r.getId(), "Rooms weren't added to hotel1");
        }

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddNullHotel() {
        hotelDao.addHotel(null);
        Assert.fail("Adding null hotel");
    }

    /*
     * Test of updateHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testUpdateHotel() {
        /* Create mock rooms */
        r1 = Mockito.mock(Room.class);
        r2 = Mockito.mock(Room.class);
        r3 = Mockito.mock(Room.class);

        /* Prepare */
        h1.addRoom(r1);
        h1.addRoom(r2);
        h1.setName("Hotel");
        hotelDao.addHotel(h1);

        /* Update name */
        h1.setName("Hotel 1");
        hotelDao.updateHotel(h1);

        String actualName = hotelDao.getHotelById(h1.getId()).getName();
        Assert.assertEquals(actualName, h1.getName(), "Hotel1 name was not updated");

        /* Were rooms modified? */
        int numberOfHotel1Rooms = hotelDao.getHotelById(h1.getId()).getRooms().size();
        Assert.assertEquals(numberOfHotel1Rooms, h1.getRooms().size(), "Hotel1 rooms were changed");

        /* Add new room */
        h1.addRoom(r3);

        /* Was it really added? */
        numberOfHotel1Rooms = hotelDao.getHotelById(h1.getId()).getRooms().size();
        Assert.assertNotNull(r3.getId(), "Room was not added to hotel1");
        Assert.assertEquals(numberOfHotel1Rooms, h1.getRooms().size(), "Room was not added to hotel1");
    }

    /*
     * Test of deleteHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testDeleteHotel() {
        /* Create mock rooms */
        r1 = Mockito.mock(Room.class);
        r2 = Mockito.mock(Room.class);

        /* Prepare */
        h1.addRoom(r1);
        h1.addRoom(r2);
        hotelDao.addHotel(h1);
        Assert.assertNotNull(h1.getId(), "Hotel1 was not added");

        /* Was it delete? */
        hotelDao.deleteHotel(h1);
        Hotel actualHotel = hotelDao.getHotelById(h1.getId());
        Assert.assertNull(actualHotel, "Hotel1 was not deleted");

        /* Were rooms delete too? */
        for (Room r : h1.getRooms()) {
            Assert.assertNull(r.getId(), "Rooms of hotel1 weren't delete");
        }
    }

    /*
     * Test of getHotelById method, of class HotelDaoImpl.
     */
    @Test
    public void testGetHotelById() {
        h1.addRoom(r1);
        h1.addRoom(r2);
        hotelDao.addHotel(h1);

        /* Get it */
        Hotel actualHotel = hotelDao.getHotelById(h1.getId());
        Assert.assertEquals(actualHotel.getName(), h1.getName(), "Name of hotel1 is not the same");

        /* Really same? Also with rooms? */
        Collection<Room> actualRoomsOfH1 = actualHotel.getRooms();
        Assert.assertEquals(actualRoomsOfH1, h1.getRooms(), "Hotel1 doesn't have same rooms");
    }

    @Test
    public void testFindAllHotels() {
        Collection<Hotel> hotels = hotelDao.findAllHotels();
        Assert.assertTrue(hotels.isEmpty());

        /* Add just one hotel */
        hotelDao.addHotel(h1);

        /* Was added really just one hotel? */
        hotels = hotelDao.findAllHotels();
        Assert.assertEquals(hotels.size(), 1);

        /* Was added really THAT hotel? */
        Assert.assertTrue(hotels.contains(h1));

        /* Add another one */
        hotelDao.addHotel(h2);

        /* Are there really two hotels? */
        hotels = hotelDao.findAllHotels();
        Assert.assertEquals(hotels.size(), 2);

        /* Same hotels? */
        Assert.assertTrue(hotels.contains(h1) && hotels.contains(h2));
    }
}
