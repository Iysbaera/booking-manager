/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import cz.muni.fi.pa165.dao.RoomDao;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import cz.muni.fi.pa165.facade.RoomFacade;
import cz.muni.fi.pa165.service.RoomService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.when;

/**
 *
 * @author Juraj Bielik
 */
@ContextConfiguration("classpath:application-context-service-test.xml")
public class RoomFacadeTest  extends AbstractTransactionalTestNGSpringContextTests{
    @Mock
    private RoomDao roomDao;

    @Autowired
    @InjectMocks
    private RoomService roomService;

    @Autowired
    private RoomFacade roomFacade;

    private Room r1;
    private Room r2;

    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void beforeMethod() throws ParseException{
        r1 = new Room();
        r2 = new Room();
        r1.setNumber(1);
        r2.setNumber(2);
        r1.setPrice(BigDecimal.ONE);
        r2.setPrice(BigDecimal.TEN);
        r1.setType(RoomType.SingleRoom);
        r2.setType(RoomType.DoubleRoom);
    }

    @Test
    public void testGetRoomById() {
        /* Prepare test */
        Long testId = 1L;
        when(roomDao.getRoomById(testId)).thenReturn(r1);

        /* Retrieve */
        RoomDto rdto = roomFacade.getRoomById(testId);

        /* Is it the same room? (Same number) */
        Assert.assertEquals(rdto.getNumber(), r1.getNumber(), "Room numbers are not the same");
    }

    @Test
    public void testGetAllRooms() {
        /* Prepare mock */
        when(roomDao.findAllRooms()).thenReturn(new ArrayList<Room>() {
            { add(r1); }
            { add(r2); }
        });

        /* Are there two rooms? */
        Collection<RoomDto> dtos = roomFacade.getAllRooms();
        Assert.assertTrue(dtos.size() == 2, "Number of rooms");
    }
}
