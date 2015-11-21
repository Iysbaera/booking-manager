package cz.muni.fi.service.impl;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.service.BookingService;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author Jana Cechackova
 * 
 * This is just a temporary file. 
 * Please delete this class, if you are ready to write Java tests for SERVICEs.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-service-test.xml"})
public class BookingServiceImplTest {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Mock
    BookingDao bookingDao;
    
    @Autowired
    BookingDto bookingDto;
    
    @Autowired	
    BookingService bookingService;
    
    Booking booking;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(bookingService, "bookingDao", bookingDao);
        booking = mapper.map(bookingDto, Booking.class);
    }
    
    @Test
    public void testAddGhost(){
        bookingService.addBooking(bookingDto);
        verify(bookingDao).addBooking(booking);
        bookingService.deleteBooking(bookingDto);
    }
}
