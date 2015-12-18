package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.facade.HotelFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        log.info("hotels = {}", hotelFacade.getAllHotels());
        model.addAttribute("hotels", hotelFacade.getAllHotels());
        return "hotel/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "hotel/create";
    }
}
