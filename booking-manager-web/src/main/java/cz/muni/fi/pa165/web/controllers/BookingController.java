package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.dto.CreateBookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.facade.BookingFacade;
import cz.muni.fi.pa165.facade.CustomerFacade;
import cz.muni.fi.pa165.facade.RoomFacade;
import java.util.Locale;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    
    @Autowired
    RoomFacade roomFacade;
    @Autowired
    CustomerFacade customerFacade;

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
        String startDate = "";
        String endDate = "";
        Booking a;

        model.addAttribute("createBooking", new CreateBookingDto());
        model.addAttribute("customers", customerFacade.getAllCustomers());
        model.addAttribute("rooms", roomFacade.getAllRooms());
        return "booking/create";
    }
    
    /**
     * Method to create new booking.
     *
     * Parameter's order has to be exactly like this! @ModelAttribute(name_of_the_entity) ..., BindingResult, and the rest
     *
     * @param booking
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("booking") CreateBookingDto booking, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/booking/create").build();
        }
        bookingFacade.createBooking(booking);


        redirectAttributes.addFlashAttribute("alert_success", "Booking was successfully created.");

        return "redirect:" + uriBuilder.path("/booking/list").build();

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
        bookingFacade.cancelBooking(id);
        redirectAttributes.addFlashAttribute("alert_success", "Booking was successfully cancelled.");

        return "redirect:" + uriBuilder.path("/booking/list").build();
    }
    
}
