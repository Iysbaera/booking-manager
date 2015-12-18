package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.facade.BookingFacade;
import cz.muni.fi.pa165.facade.HotelFacade;
import cz.muni.fi.pa165.facade.RoomFacade;
import cz.muni.fi.pa165.web.validators.RoomValidator;
import javassist.NotFoundException;
import org.slf4j.Logger;
import cz.muni.fi.pa165.enumeration.RoomType;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
import java.text.NumberFormat;
import java.text.ParseException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Michal Hornak
 */
@Controller
@RequestMapping("/room")
public class RoomController {

    final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @ModelAttribute("customer")
    public CreateRoomDto getRoom(){
        return new CreateRoomDto();
    }

    @Autowired
    RoomFacade roomFacade;

    @Autowired
    HotelFacade hotelFacade;
    @Autowired
    BookingFacade bookingFacade;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof CreateRoomDto) {
            binder.addValidators(new RoomValidator());
        }
    }

    /**
     * Method to list all rooms stored in a database.
     *
     * @param model =
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String rooms(Model model) {
        log.info("rooms = {}", roomFacade.getAllRooms());
        Collection<Long> toDelete = new ArrayList<Long>();
        for(RoomDto r: roomFacade.getAllRooms()) {
          if(bookingFacade.getAllRoomBookings(r.getId()).isEmpty()){
              toDelete.add(r.getId());
          }
        }
        model.addAttribute("rooms", roomFacade.getAllRooms());
        model.addAttribute("toDelete", toDelete);
        return "room/list";
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
       roomFacade.deleteRoom(id);

        return "redirect:" + uriBuilder.path("/room/list").build();
    }

    /**
     * Method to run a new page with a form for new rooms.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        log.debug("create new");
        model.addAttribute("createRoom", new CreateRoomDto());
        model.addAttribute("hotels", hotelFacade.getAllHotels());
        model.addAttribute("roomTypes", RoomType.values());
        return "room/create";
    }

    /**
     * Method to create new room.
     *
     * Parameter's order has to be exactly like this! @ModelAttribute(name_of_the_entity) ..., BindingResult, and the rest
     *
     * @param room
     * @param bindingResult
     * @param redirectAttributes
     * @param uriBuilder
     * @param locale
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("room") CreateRoomDto room, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {


        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Some data were not filled!");
            return "redirect:" + uriBuilder.path("/room/create").build();
        }
        roomFacade.createRoom(room);

        redirectAttributes.addFlashAttribute("alert_success", "Room was successfully created.");

        return "redirect:" + uriBuilder.path("/room/list").build();

    }
    /**
     * Method to change room price.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable long id,Model model) {
        RoomDto room = roomFacade.getRoomById(id);

        if(room == null) {
            // throw exception
        }
        String price= "";
        model.addAttribute("room", room);
        model.addAttribute("price", price);

        log.debug("change price");
        return "room/update";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("price") String price, @PathVariable long id,Model model,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes, Locale locale,
                              UriComponentsBuilder uriBuilder) {
        /*
        Nutne vyriesit importy na zaklade locale.
         */

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("alert_failure", "Price was not filled!");
            return "redirect:" + uriBuilder.path("/room/update/"+id).build();
        }
        NumberFormat nf = NumberFormat.getInstance(locale);
        try{
            BigDecimal price_bd = new BigDecimal(nf.parse(price).toString());
            if (price_bd.compareTo(BigDecimal.ZERO) > 0){
                roomFacade.changePrice(id,price_bd);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        log.debug("change price");
        return "redirect:" + uriBuilder.path("/room/list").build();
    }

}
