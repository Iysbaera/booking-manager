package service;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.service.HotelService;
import org.dozer.DozerBeanMapper;
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

import static org.mockito.Mockito.when;

/**
 * @author expres
 */
@ContextConfiguration(locations = {"classpath:application-context-service-test.xml"})
public class HotelServiceImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    DozerBeanMapper mapper;

    @Mock
    HotelDao hotelDao;

    @Autowired
    @InjectMocks
    private HotelService hotelService;

    private Hotel hotel;

    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUp() {
        hotel = new Hotel();
        hotel.setName("hotel");
    }

    /**
     * Test of addHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testAddHotel() {
        hotelService.addHotel(hotel);

        when(hotelDao.getHotelById(hotel.getId())).thenReturn(hotel);
        Assert.assertNotNull(hotelService.getHotelById(hotel.getId()));
    }

    /**
     * Test of deleteHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testDeleteHotel() {
        hotelService.addHotel(hotel);

        when(hotelDao.getHotelById(hotel.getId())).thenReturn(hotel);
        Assert.assertNotNull(hotelService.getHotelById(hotel.getId()));

        hotelService.deleteHotel(hotel);
        when(hotelDao.getHotelById(hotel.getId())).thenReturn(null);
        Assert.assertNull(hotelService.getHotelById(hotel.getId()));
    }

    /**
     * Test of updateHotel method, of class HotelServiceImpl.
     */
    @Test
    public void testUpdateHotel() {
        hotelService.addHotel(hotel);
        hotel.setName("New name");
        hotelService.updateHotel(hotel);

        when(hotelDao.getHotelById(hotel.getId())).thenReturn(hotel);
        Assert.assertEquals(hotelService.getHotelById(hotel.getId()).getName(), hotel.getName());
    }

    /**
     * Test of getHotelDtoById method, of class HotelServiceImpl.
     */
    @Test
    public void testGetHotelById() {
        hotelService.addHotel(hotel);

        when(hotelDao.getHotelById(hotel.getId())).thenReturn(hotel);
        Hotel output = hotelService.getHotelById(hotel.getId());

        Assert.assertEquals(output, hotel);
    }
}
