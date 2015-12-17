package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.dto.RoomDto;
import cz.muni.fi.pa165.facade.RoomFacade;
import javassist.NotFoundException;
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
import java.text.NumberFormat;
import java.text.ParseException;

import java.math.BigDecimal;
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


    /**
     * Method to list all rooms stored in a database.
     *
     * @param model =
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String rooms(Model model) {
        log.info("rooms = {}", roomFacade.getAllRooms());
        model.addAttribute("rooms", roomFacade.getAllRooms());
        return "room/list";
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
        return "room/create";
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
    public String create(@ModelAttribute("room") CreateRoomDto room, BindingResult bindingResult, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder, Locale locale) {

        if (bindingResult.hasErrors()){
            return "error";
        }

        roomFacade.createRoom(room);

        return "redirect:" + uriBuilder.path("/room/list").build();

    }

}
