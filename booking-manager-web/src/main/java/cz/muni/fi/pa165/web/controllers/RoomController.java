package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.facade.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomFacade roomFacade;
}
