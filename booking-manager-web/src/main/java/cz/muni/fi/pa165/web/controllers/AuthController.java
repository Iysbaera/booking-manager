package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.dto.CreateCustomerDto;
import cz.muni.fi.pa165.facade.CustomerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/auth")
public class AuthController {

    final static Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    CustomerFacade customerFacade;

    @RequestMapping(value = "/register", method = GET)
    public String getRegistration(Model model) {
        model.addAttribute("customer", new CreateCustomerDto());
        return "auth/register";
    }

    @RequestMapping(value = "/register", method = POST)
    public String postRegistration(@ModelAttribute("customer") CreateCustomerDto customer, BindingResult result) {
        customerFacade.createCustomer(customer);
        return "redirect:/hotel/list";
    }

    @RequestMapping(value = "/login", method = GET)
    public String getLogin(Model model) {
        model.addAttribute("customer", new CreateCustomerDto());
        return "auth/login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String postLogin(Model model) {
        return "auth/login";
    }
}
