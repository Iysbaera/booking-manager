package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.facade.CustomerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    CustomerFacade customerFacade;
}
