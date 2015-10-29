/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import java.math.BigDecimal;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional

@ContextConfiguration("classpath:applicationContextTest.xml")
public class RoomDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RoomDao roomDao;
    
    //rooms
    private Room room1;
    private Room room2;

    //hotels
    @Mock private Hotel hotel1;
    @Mock private Hotel hotel2;
    
    @BeforeMethod
    public void setUp() {
        /*Create first room*/
        room1 = new Room();
        room1.setNumber(1);
        room1.setPrice(new BigDecimal("10"));
        room1.setType(RoomType.SingleRoom);
        
        /*Create second room*/
        room2 = new Room();
        room2.setNumber(2);
        room2.setPrice(new BigDecimal("50"));
        room2.setType(RoomType.DeluxeRoom);
    }

    /**
     * Test of addRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testAddRoom() {
        roomDao.addRoom(room1);
        Assert.assertEquals(roomDao.getRoomById(room1.getId()).getNumber(), 1);
    }

    /**
     * Test of updateRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testUpdateRoom() {
        roomDao.addRoom(room1);
        Assert.assertNotNull(roomDao.getRoomById(room1.getId()));
        
        room1.setNumber(5);
        roomDao.updateRoom(room1);
        Assert.assertEquals(roomDao.getRoomById(room1.getId()).getNumber(), 5);
    }

    /**
     * Test of deleteRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testDeleteRoom() {
        roomDao.addRoom(room1);
        Assert.assertNotNull(roomDao.getRoomById(room1.getId()));
        
        roomDao.deleteRoom(room1);
        Assert.assertNull(roomDao.getRoomById(room1.getId()));
    }

    /**
     * Test of getRoomById method, of class RoomDaoImpl.
     */
    @Test
    public void testGetRoomById() {
        roomDao.addRoom(room1);
        Room output = roomDao.getRoomById(room1.getId());
        Assert.assertEquals(room1.getNumber(), output.getNumber());
    }

}
