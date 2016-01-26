package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.*;
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
import org.springframework.validation.FieldError;
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
        Collection<Long> toDelete = new ArrayList<Long>();
        for(HotelDto h: hotelFacade.getAllHotels()){
            if(bookingFacade.getAllHotelBookings(h.getId()).isEmpty()
                    && h.getRooms().isEmpty()){
                toDelete.add(h.getId());
            }
        }
        model.addAttribute("hotels", hotelFacade.getAllHotels());
        model.addAttribute("toDelete", toDelete);
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

        if (bindingResult.hasFieldErrors()){
            for(FieldError error : bindingResult.getFieldErrors()){
                 if (error.getField().equals("name")) 
                      redirectAttributes.addFlashAttribute("alert_failure", "Has to have at least 3 characters!");
            }
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
    /**
     * Method to delete a room.
     *
     * @param id
     * @param locale
     * @param uriBuilder
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Locale locale, UriComponentsBuilder uriBuilder) {
        log.debug("delete({})", id);
        hotelFacade.deleteHotel(id);

        return "redirect:" + uriBuilder.path("/hotel/list").build();
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit_form(@PathVariable long id, Model model) {

        model.addAttribute("hotel", hotelFacade.getHotelById(id));
        log.debug("update_form(model={})", model);
        return "hotel/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @Valid @ModelAttribute("hotel") CreateHotelDto hotel, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {

        if (bindingResult.hasFieldErrors()){

            for(FieldError error: bindingResult.getFieldErrors()){

                if (error.getField().equals("name"))
                    redirectAttributes.addFlashAttribute("alert_failure", "Name is empty!");
            }
            return "redirect:" + uriBuilder.path("/hotel/edit/"+id).build();
        }

        HotelDto updatedHotel = hotelFacade.getHotelById(id);
        updatedHotel.setName(hotel.getName());

        hotelFacade.updateHotel(updatedHotel);
        redirectAttributes.addFlashAttribute("alert_success", "Hotel was successfully updated.");

        return "redirect:" + uriBuilder.path("/hotel/list").build();

    }
}
