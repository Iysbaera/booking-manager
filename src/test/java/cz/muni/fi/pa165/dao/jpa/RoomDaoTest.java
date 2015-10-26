/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.entity.Room;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class RoomDaoTest extends AbstractTestNGSpringContextTests {   
    
    @Autowired
    private RoomDao roomDao;
    
    @Before
    public void setUp() {
    }    

    /**
     * Test of addRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testAddRoom() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testUpdateRoom() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testDeleteRoom() {
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomById method, of class RoomDaoImpl.
     */
    @Test
    public void testGetRoomById() {
        fail("The test case is a prototype.");
    }
    
}
