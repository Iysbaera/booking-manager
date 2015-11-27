/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.entity.Hotel;

import org.testng.Assert;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import cz.muni.fi.pa165.service.RoomService;
import cz.muni.fi.pa165.service.RoomServiceImpl;
import java.math.BigDecimal;
import java.text.ParseException;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author expres
 */
public class RoomServiceImplTest {
    
    public RoomServiceImplTest() {
    }
    
    @Autowired
    DozerBeanMapper mapper;
            
    @Mock private Hotel hotel;
    @Mock private Hotel hotel2;
    
    @Autowired	
    @InjectMocks
    private RoomService roomService;
    
    private Room room;
    private Room room2;
    
    @BeforeMethod
    public void setUp() throws ParseException{
        MockitoAnnotations.initMocks(this);
	room = new Room();
	room2 = new Room();
        room.setNumber(1);
        room2.setNumber(2);
        room.setPrice(BigDecimal.ONE);
        room2.setPrice(BigDecimal.TEN);
        room.setType(RoomType.SingleRoom);
        room2.setType(RoomType.DoubleRoom);
    }
    

    /**
     * Test of addRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testAddRoom() {
        hotel = Mockito.mock(Hotel.class);
        hotel2= Mockito.mock(Hotel.class);
        room.setHotel(hotel);
        room2.setHotel(hotel2);
        roomService.addRoom(room);
        roomService.addRoom(room2);
        Assert.assertNotNull(room.getId());
        Assert.assertNotNull(room2.getId());
        int roomNumber = roomService.getRoomDtoById(room.getId()).getNumber();
        int roomNumber2 = roomService.getRoomDtoById(room2.getId()).getNumber();
        Assert.assertEquals(roomNumber,room.getNumber());
        Assert.assertEquals(roomNumber2,room2.getNumber());
        
    }

    /**
     * Test of deleteRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testDeleteRoom() {
        hotel = Mockito.mock(Hotel.class);
        hotel2 = Mockito.mock(Hotel.class);
        room.setHotel(hotel);
        room2.setHotel(hotel2);
        roomService.addRoom(room);
        roomService.addRoom(room2);
        Assert.assertNotNull(room.getId(),"Room not added.");
        Assert.assertNotNull(room2.getId(),"Room2 not added.");
        roomService.deleteRoom(room);
        roomService.deleteRoom(room2);
        Assert.assertNull(roomService.getRoomDtoById(room.getId()));
        Assert.assertNull(roomService.getRoomDtoById(room2.getId()));
        
        Hotel h = room.getHotel();
        Assert.assertNull(h.getId(), "Hotel of room wasn't removed");
        Hotel h2 = room2.getHotel();
        Assert.assertNull(h2.getId(), "Hotel of room wasn't removed");
    }

    /**
     * Test of updateRoom method, of class RoomServiceImpl.
     */
    @Test
    public void testUpdateRoom() {
        hotel = Mockito.mock(Hotel.class);
        hotel2 = Mockito.mock(Hotel.class);
        room.setHotel(hotel);
        roomService.addRoom(room);
        roomService.addRoom(room2);
        room.setNumber(3);
        room2.setNumber(4);
        room2.setHotel(hotel2);
        roomService.updateRoom(room);
        roomService.updateRoom(room2);
        Assert.assertEquals(room.getNumber(), roomService.getRoomDtoById(room.getId()).getNumber());
        Assert.assertEquals(room2.getNumber(), roomService.getRoomDtoById(room2.getId()).getNumber());
        Assert.assertNotNull(hotel2.getId(),"hotel2 not added to room2");
        
    }

    /**
     * Test of getRoomDtoById method, of class RoomServiceImpl.
     */
    @Test
    public void testGetRoomDtoById() {
        hotel = Mockito.mock(Hotel.class);
        room.setHotel(hotel);
        roomService.addRoom(room);
        Assert.assertEquals(room.getNumber(), roomService.getRoomDtoById(room.getId()).getNumber());
        Assert.assertNotNull(room.getId(),"Room was not added.");
        Assert.assertNotNull(roomService.getRoomDtoById(room.getId())
                ,"Room Service does not retrieve room by id.");
    }
    
}
