package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.facade.HotelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 *
 * @author Ivo Hradek
 */
@Controller
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelFacade hotelFacade;

    @RequestMapping(method = RequestMethod.GET)
    public String hotels(Model model) {
        model.addAttribute("hotels", hotelFacade.getAllHotels());
        return "hotels";
    }

    // @RequestMapping(method = RequestMethod.GET)
    // public Collection<HotelDto> hotels() {
    //     return hotelFacade.getAllHotels();
    // }
}
