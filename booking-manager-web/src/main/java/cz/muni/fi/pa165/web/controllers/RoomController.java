package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.dto.CreateRoomDto;
import cz.muni.fi.pa165.facade.RoomFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
