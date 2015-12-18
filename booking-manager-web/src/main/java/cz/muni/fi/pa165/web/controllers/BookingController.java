package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateBookingDto;
import cz.muni.fi.pa165.facade.BookingFacade;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Juraj Bielik
 */
@Controller
@RequestMapping("/booking")
public class BookingController {
    final static Logger log = LoggerFactory.getLogger(BookingController.class);

    @ModelAttribute("booking")
    public CreateBookingDto getbooBookingDto(){
        return new CreateBookingDto();
    }

    @Autowired
    BookingFacade bookingFacade;

    /**
     * Method to list all bookings stored in a database.
     *
     * @param model =
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String bookings(Model model) {
        log.info("bookings = {}", bookingFacade.getAllBookings());
        model.addAttribute("bookings", bookingFacade.getAllBookings());
        return "booking/list";
    }
    
    /**
     * Method to run a new page with a form for new bookings.
     * 
     * @param model
     * @return 
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("create new");
        return "booking/create";
    }
    
    /**
     * Method to delete a booking.
     *
     * @param id
     * @param locale
     * @param uriBuilder
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Locale locale, 
            UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        log.debug("delete({})", id);
        System.out.println("DELETUJE SA");
        bookingFacade.cancelBooking(id);
        redirectAttributes.addFlashAttribute("alert_success", "Booking was successfully cancelled.");

        return "redirect:" + uriBuilder.path("/booking/list").build();
    }
    
}
