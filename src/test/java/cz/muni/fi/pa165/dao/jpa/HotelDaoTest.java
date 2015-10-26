/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pa165.dao.jpa;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Hotel;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;

/**
 *
 * @author Juraj Bielik
 */
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class HotelDaoTest extends AbstractTestNGSpringContextTests {    
    
    @Autowired
    private HotelDao hotelDao;
    
    private Hotel hotel1;
    
    @Before
    public void setUp() {
        hotel1 = new Hotel();
        hotel1.setName("Hilton");
    }    

    /**
     * Test of addHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testAddHotel() {
        hotelDao.addHotel(hotel1);
        Assert.assertEquals(hotelDao.getHotelById(hotel1.getId()).getName(),
                            "Hilton");
    }

    /**
     * Test of updateHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testUpdateHotel() {
        hotelDao.addHotel(hotel1);
        Assert.assertNotNull(hotelDao.getHotelById(hotel1.getId()));
        
        hotel1.setName("Super 8");
        hotelDao.updateHotel(hotel1);
        Assert.assertEquals(hotelDao.getHotelById(hotel1.getId()).getName(),
                            "Super 8");
    }

    /**
     * Test of deleteHotel method, of class HotelDaoImpl.
     */
    @Test
    public void testDeleteHotel() {
        hotelDao.addHotel(hotel1);
        Assert.assertNotNull(hotelDao.getHotelById(hotel1.getId()));
        
        hotelDao.deleteHotel(hotel1);
        Assert.assertNull(hotelDao.getHotelById(hotel1.getId()));
    }

    /**
     * Test of getHotelById method, of class HotelDaoImpl.
     */
    @Test
    public void testGetHotelById() {
        hotelDao.addHotel(hotel1);
        Hotel result = hotelDao.getHotelById(hotel1.getId());
        Assert.assertEquals(hotel1.getName(), result.getName());
    }
    
}
