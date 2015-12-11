package cz.muni.fi.pa165.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "auth/login";
    }
    // @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    // public ModelAndView indexPage() {
    //     ModelAndView model = new ModelAndView();
    //     model.setViewName("home");
    //     return model;
    // }

    // @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    // public ModelAndView login(
    //         @RequestParam(value = "error",required = false) String error,
    //         @RequestParam(value = "logout", required = false) String logout) {

    //     ModelAndView model = new ModelAndView();
    //     if (null != error) {
    //         model.addObject("error", "Invalid Credentials");
    //     }

    //     if (null != logout) {
    //         model.addObject("message", "Logged out");
    //     }

    //    model.setViewName("auth/login");
    //    return model;
    //}
}
