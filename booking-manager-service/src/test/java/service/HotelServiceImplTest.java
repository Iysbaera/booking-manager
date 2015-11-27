/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.service.HotelService;
import org.dozer.DozerBeanMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author expres
 */
@Transactional
@ContextConfiguration("classpath:application-context-test.xml")
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class HotelServiceImplTest extends AbstractTransactionalTestNGSpringContextTests{
    
    
    @Autowired
    DozerBeanMapper mapper;
        
    @Autowired
    HotelDto hotelDto;
    
    @Mock private Room room;
    @Mock private Room room2;
    @Mock private Booking booking;
    
    @Autowired	
    @InjectMocks
    private HotelService hotelService;
    
    private Hotel hotel;
    private Hotel hotel2;
    
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        hotel = new Hotel();
        hotel2 = new Hotel();
        hotel.setName("hotel");
        hotel2.setName("hotel2");
    }
    
    /**
     * Test of addHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testAddHotel() {
        room = Mockito.mock(Room.class);
        room2 = Mockito.mock(Room.class);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotelService.addHotel(hotel);
        hotelService.addHotel(hotel);        
        Assert.assertNotNull(hotel.getId());
        Assert.assertNotNull(hotel2.getId());
        String hotelName = hotelService.getHotelById(hotel.getId()).getName();
        String hotelName2 = hotelService.getHotelById(hotel2.getId()).getName();
        Assert.assertEquals(hotelName,hotel.getName());
        Assert.assertEquals(hotelName2,hotel2.getName());
        
        int numberOfRoomsHotel1 =
                hotelService.getHotelById(hotel.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel1, hotel.getRooms().size(), "Number of hotel1 rooms are not same");
        int numberOfRoomsHotel2 =
                hotelService.getHotelById(hotel.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel2, hotel.getRooms().size(), "Number of hotel2 rooms are not same");
        
        for (Room r : hotel.getRooms()) {
            Assert.assertNotNull(r.getId(), "Rooms weren't added to hotel1");
        }
    }

    /**
     * Test of deleteHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testDeleteHotel() {
        room = Mockito.mock(Room.class);
        room2 = Mockito.mock(Room.class);
        hotel.addRoom(room);
        hotel.addRoom(room2);
        hotelService.addHotel(hotel);
        Assert.assertNotNull(hotel.getId(),"Hotel not added.");
        hotelService.deleteHotel(hotel);
        Assert.assertNull(hotelService.getHotelById(hotel.getId()));
        
        for (Room r : hotel.getRooms()) {
            Assert.assertNull(r.getId(), "Rooms of hotel weren't delete");
        }
    }

    /**
     * Test of updateHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testUpdateHotel() {
        room = Mockito.mock(Room.class);
        room2 = Mockito.mock(Room.class);
        hotel.addRoom(room);
        hotelService.addHotel(hotel);
        hotel.setName("motel");
        hotel.addRoom(room);
        hotelService.updateHotel(hotel);
        Assert.assertEquals(hotel.getName(), hotelService.getHotelById(hotel.getId()).getName());
        Assert.assertNotNull(room.getId(),"room not added");
        
        int numberOfRoomsHotel =
                hotelService.getHotelById(hotel.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel, hotel.getRooms().size(), "Number of hotel rooms wasnt updated");
        
        hotel.addRoom(room2);
        hotelService.updateHotel(hotel);
        
        Assert.assertEquals(hotel.getName(), hotelService.getHotelById(hotel.getId()).getName());
        
        int numberOfRoomsHotel2 =
                hotelService.getHotelById(hotel.getId())
                        .getRooms()
                        .size();
        Assert.assertSame(numberOfRoomsHotel2, hotel.getRooms().size(), "Number of hotel rooms wasnt updated");
        
    }

    /**
     * Test of getHotelDtoById method, of class HotelServiceImpl.
     */
    @Test
    public void testGetHotelById() {
        room = Mockito.mock(Room.class);
        hotel.addRoom(room);
        hotelService.addHotel(hotel);
        Assert.assertEquals(hotel.getName(), hotelService.getHotelById(hotel.getId()).getName());
        Assert.assertNotNull(hotel.getId(),"Hotel was not added.");
        Assert.assertNotNull(hotelService.getHotelById(hotel.getId())
                ,"Hotel Service does not retrieve hotel by id.");
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAddNullHotel() {
        hotelService.addHotel(null);
        Assert.fail("Adding null hotel");
    }
}
