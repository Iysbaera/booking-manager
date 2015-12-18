package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.dto.CreateHotelDto;
import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.facade.BookingFacade;
import cz.muni.fi.pa165.facade.HotelFacade;
import cz.muni.fi.pa165.facade.RoomFacade;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 *
 * @author Ivo Hradek
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelFacade hotelFacade;
    @Autowired
    private BookingFacade bookingFacade;
    @Autowired
    private RoomFacade roomFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.info("hotels = {}", hotelFacade.getAllHotels());
        model.addAttribute("hotels", hotelFacade.getAllHotels());
        return "hotel/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("create new hotel");
        model.addAttribute("createHotel", new CreateHotelDto());
        return "hotel/create";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("hotel") CreateHotelDto hotel, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/hotel/create").build();
        }
        hotelFacade.createHotel(hotel);

        redirectAttributes.addFlashAttribute("alert_success", "Hotel was successfully created.");

        return "redirect:" + uriBuilder.path("/hotel/list").build();

    }
    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model) {
        Collection<BookingDto> bookings = new ArrayList<BookingDto>();
        Collection<Long> freeRooms = new ArrayList<Long>();
        Collection<RoomDto> rooms = new ArrayList<RoomDto>();
        bookings = bookingFacade.getAllHotelBookings(id);
        rooms = hotelFacade.getHotelById(id).getRooms();
        for(RoomDto r: rooms){
            freeRooms.add(r.getId());
        }
        for(BookingDto b: bookings){
            RoomDto room = b.getRoom();
            if(rooms.contains(room)) {
                freeRooms.remove(room.getId());
            }
        }
        model.addAttribute("hotel", hotelFacade.getHotelById(id));
        model.addAttribute("freeRooms", freeRooms);
        return "hotel/show";
    }
}
