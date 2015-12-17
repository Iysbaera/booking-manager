package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateBookingDto;
import cz.muni.fi.pa165.facade.BookingFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ivo on 12/15/15.
 */
@Controller
@RequestMapping("/booking")
public class BookingController {
    final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @ModelAttribute("booking")
    public CreateBookingDto getbooBookingDto(){
        return new CreateBookingDto();
    }

    @Autowired
    BookingFacade bookingFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String bookings(Model model) {
        log.info("bookings = {}", bookingFacade.getAllBookings());
        model.addAttribute("bookings", bookingFacade.getAllBookings());
        return "booking/list";
    }
}
