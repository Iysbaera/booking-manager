package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Hotel;

import cz.muni.fi.pa165.entity.Room;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
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
@ContextConfiguration("classpath:applicationContextTest.xml")
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class HotelDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private RoomDao roomDao;

    /* Hotels */
    private Hotel h1;
    private Hotel h2;

    /* Rooms */
    @Mock private Room r1;
    @Mock private Room r2;
    @Mock private Room r3;

    @BeforeMethod
    public void setUp() {
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
        Assert.assertSame(numberOfRoomsHotel1, h2.getRooms().size(), "Number of hotel1 rooms are not same");

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
        Collection<Room> actualRooms = hotelDao.getHotelById(h1.getId()).getRooms();
        Assert.assertEquals(actualRooms, h1.getRooms(), "Hotel1 rooms were changed");

        /* Add new room */
        h1.addRoom(r3);

        /* Was it really added? */
        actualRooms = hotelDao.getHotelById(h1.getId()).getRooms();
        Assert.assertNotNull(r3, "Room was not added to hotel1");
        Assert.assertEquals(actualRooms.size(), h1.getRooms().size(), "Room was not added to hotel1");

        /* Were rooms modified? */
        Assert.assertEquals(actualRooms, h1.getRooms(), "Rooms of hotel1 were modified");
    }

    /*
     * Test of deleteHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testDeleteHotel() {
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
            Assert.assertNull(roomDao.getRoomById(r.getId()), "Rooms of hotel1 weren't delete");
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

    }

    @Test
    public void testFindFreeRooms() {

    }
}
