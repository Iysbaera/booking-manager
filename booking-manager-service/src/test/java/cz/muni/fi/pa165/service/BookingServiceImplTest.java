package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.BookingDao;
import cz.muni.fi.pa165.service.BookingService;
import org.dozer.DozerBeanMapper;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
@Transactional
@ContextConfiguration(locations = {"classpath:/applicationContext-service-test.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
public class BookingServiceImplTest {
    
    @Autowired
    DozerBeanMapper mapper;
    
    @Mock
    BookingDao bookingDao;

    @Autowired
    BookingService bookingService;
    
    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(bookingService, "bookingDao", bookingDao);
    }
    
    @Test
    public void addBooking(){
    }
}
