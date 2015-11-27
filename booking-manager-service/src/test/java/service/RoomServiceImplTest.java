package service;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import cz.muni.fi.pa165.service.RoomService;
import java.math.BigDecimal;
import java.text.ParseException;
import org.dozer.DozerBeanMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author expres
 */
@ContextConfiguration(locations = {"classpath:application-context-service-test.xml"})
public class RoomServiceImplTest extends AbstractTransactionalTestNGSpringContextTests{    
    
    @Autowired
    DozerBeanMapper mapper;
            
    @Mock
    RoomDao roomDao;
    
    @Autowired	
    @InjectMocks
    private RoomService roomService;
    
    private Room room;
    
    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeMethod
    public void setUp() throws ParseException{
	room = new Room();
        room.setNumber(1);      
        room.setPrice(BigDecimal.ONE);
        room.setType(RoomType.SingleRoom);      
    }
    

    /**
     * Test of addRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testAddRoom() {
        roomService.addRoom(room);
	
	when(roomDao.getRoomById(room.getId())).thenReturn(room);
	Assert.assertNotNull(roomService.getRoomDtoById(room.getId()));
    }

    /**
     * Test of deleteRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testDeleteRoom() {
	roomService.addRoom(room);
	
	when(roomDao.getRoomById(room.getId())).thenReturn(room);
        Assert.assertNotNull(roomService.getRoomDtoById(room.getId()));

        roomService.deleteRoom(room);
	when(roomDao.getRoomById(room.getId())).thenReturn(null);
        Assert.assertNull(roomService.getRoomDtoById(room.getId()));
    }

    /**
     * Test of updateRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testUpdateRoom() {
	roomService.addRoom(room);
	room.setNumber(3);
        room.setPrice(BigDecimal.ZERO);
        room.setType(RoomType.DoubleRoom);
	roomService.updateRoom(room);
	
	when(roomDao.getRoomById(room.getId())).thenReturn(room);
	Assert.assertEquals(roomService.getRoomDtoById(room.getId()).getNumber(), room.getNumber());
        Assert.assertEquals(roomService.getRoomDtoById(room.getId()).getType(), room.getType());
        Assert.assertEquals(roomService.getRoomDtoById(room.getId()).getPrice(), room.getPrice());
    }

    /**
     * Test of getRoomDtoById method, of class RoomServiceImpl.
     */
    @Test
    public void testGetRoomDtoById() {
        roomService.addRoom(room);
	
	when(roomDao.getRoomById(room.getId())).thenReturn(room);
        Room output = roomService.getRoomDtoById(room.getId());
	
        Assert.assertEquals(output, room);      
    }
    
}
