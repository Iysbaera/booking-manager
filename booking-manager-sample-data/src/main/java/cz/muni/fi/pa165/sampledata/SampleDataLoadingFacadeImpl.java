package cz.muni.fi.pa165.sampledata;

import cz.muni.fi.pa165.service.BookingService;
import cz.muni.fi.pa165.service.CustomerService;
import cz.muni.fi.pa165.service.HotelService;
import cz.muni.fi.pa165.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Implementation of {@link SampleDataLoadingFacade}.
 *
 * @see SampleDataLoadingFacade
 * @author Ivo Hradek
 */
@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;

    @Override
    public void loadData() throws IOException {
        /* TODO: Fill with sample data */
    }
}
