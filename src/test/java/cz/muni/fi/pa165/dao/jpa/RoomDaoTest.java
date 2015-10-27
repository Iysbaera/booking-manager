/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoomDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RoomDao roomDao;

    @BeforeMethod
    public void setUp() {
    }

    /**
     * Test of addRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testAddRoom() {
        Assert.fail("The test case is a prototype.");
    }

    /**
     * Test of updateRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testUpdateRoom() {
        Assert.fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRoom method, of class RoomDaoImpl.
     */
    @Test
    public void testDeleteRoom() {
        Assert.fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomById method, of class RoomDaoImpl.
     */
    @Test
    public void testGetRoomById() {
        Assert.fail("The test case is a prototype.");
    }

}
