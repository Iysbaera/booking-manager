package facade;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.facade.HotelFacade;
import cz.muni.fi.pa165.service.HotelService;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.when;

@ContextConfiguration("classpath:application-context-service-test.xml")
public class HotelFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    @Mock
    Room r1;
    @Mock
    Room r2;
    @Mock
    private HotelDao hotelDao;

    @Autowired
    @InjectMocks
    private HotelService hotelService;

    @Autowired
    private HotelFacade hotelFacade;

    private Hotel h1;
    private Hotel h2;

    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void beforeMethod() throws ParseException {
        h1 = new Hotel();
        h1.setName("Test hotel 1");

        h2 = new Hotel();
        h2.setName("Test hotel 2");
    }

    @Test
    public void testGetHotelById() {
        /* Prepare test */
        Long testId = 1L;
        when(hotelDao.getHotelById(testId)).thenReturn(h1);

        /* Retrieve */
        HotelDto hdto = hotelFacade.getHotelById(testId);

        /* Is it same hotel? (Same name) */
        Assert.assertEquals(hdto.getName(), h1.getName(), "Hotel name is not same");
    }

    @Test
    public void testGetAllHotels() {
        /* Prepare mock */
        when(hotelDao.findAllHotels()).thenReturn(new ArrayList<Hotel>() {
            { add(h1); }
            { add(h2); }
        });

        /* Are there two hotels */
        Collection<HotelDto> dtos = hotelFacade.getAllHotels();
        Assert.assertTrue(dtos.size() == 2, "Number of hotels");
    }
}
