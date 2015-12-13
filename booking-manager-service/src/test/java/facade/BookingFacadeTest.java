package facade;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.dto.CreateBookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.facade.BookingFacade;
import cz.muni.fi.pa165.service.BookingService;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.when;

@ContextConfiguration("classpath:application-context-service-test.xml")
public class BookingFacadeTest extends AbstractTransactionalTestNGSpringContextTests {
    @Mock
    private Hotel h;
    @Mock
    private Room r;
    @Mock
    private BookingDao bookingDao;

    @Autowired
    @InjectMocks
    private BookingService bookingService;

    @Autowired
    private BookingFacade bookingFacade;

    private Booking b1;
    private Booking b2;
    private SimpleDateFormat sdf;

    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }

    @BeforeMethod
    public void beforeMethod() throws ParseException {
        b1 = new Booking();
        b1.setCheckIn(sdf.parse("01-01-2015"));
        b1.setCheckOut(sdf.parse("07-01-2015"));

        b2 = new Booking();
        b2.setCheckIn(sdf.parse("01-01-2015"));
        b2.setCheckOut(sdf.parse("07-01-2015"));
    }

    @Test
    public void testGetBookById() {
        /* Prepare test */
        Long testId = 1L;
        when(bookingDao.getBookingById(testId)).thenReturn(b1);

        /* Retrieve */
        BookingDto bdto = bookingFacade.getBookingById(testId);

        /* Same check-in and check-out */
        Assert.assertTrue(bdto.getCheckIn().equals(b1.getCheckIn()), "Booking's check-in");
        Assert.assertTrue(bdto.getCheckOut().equals(b1.getCheckOut()), "Booking's check-out");
    }

    @Test
    public void testGetAllBookings() {
        /* Prepare mock */
        when(bookingDao.findAllBookings()).thenReturn(new ArrayList<Booking>() {
            {
                add(b1);
            }

            {
                add(b2);
            }
        });

        /* Are there two bookings */
        Collection<BookingDto> dtos = bookingFacade.getAllBookings();
        Assert.assertTrue(dtos.size() == 2, "Number of bookings");
    }

    @Test
    public void testGetHotelBookings() {
        /* Prepare test */
        // Long hId = 1L;
        // when(h.getId()).thenReturn(hId);
        // when(r.getHotel()).thenReturn(h);
        // when(bookingDao.findAllBookings()).thenReturn(new ArrayList<Booking>() {
        //     {
        //         add(b1);
        //     }

        //     {
        //         add(b2);
        //     }
        // });
        // b1.setRoom(r);
        // b2.setRoom(r);

        // Collection<BookingDto> dtos = bookingFacade.getAllHotelBookings(h.getId());
        // Assert.assertTrue(dtos.size() == 2, "Number of bookings");

    }

    @Test
    public void testGetRoomBookings() {
        /* Prepare test */
        // Long roomId = 1L;
        // when(r.getId()).thenReturn(roomId);
        // when(bookingDao.findAllBookings()).thenReturn(new ArrayList<Booking>() {
        //     {
        //         add(b1);
        //     }

        //     {
        //         add(b2);
        //     }
        // });
        // b1.setRoom(r);
        // b2.setRoom(r);

        // Collection<BookingDto> dtos = bookingFacade.getAllRoomBookings(r.getId());
        // Assert.assertTrue(dtos.size() == 2, "Number of bookings");
    }

    @Test
    public void testCreateBooking() {
        /* Prepare test */
        CreateBookingDto booking = new CreateBookingDto();
        booking.setCustomerId(1L);
        booking.setRoomId(1L);

        // Assert.assertNotNull(id, "Booking was not created");
    }
}
