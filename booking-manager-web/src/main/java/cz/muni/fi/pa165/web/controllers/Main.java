package cz.muni.fi.pa165.web.controllers;

import cz.muni.fi.pa165.facade.HotelFacade;
import cz.muni.fi.pa165.facade.HotelFacadeImpl;

public class Main {

    public static void main(String... args) {
        HotelFacade hotelFacade = new HotelFacadeImpl();
        if (null == hotelFacade) {
            System.out.println("NOK");
        }
        if(null == hotelFacade.getAllHotels()) {
            System.out.println("NOK");
        }
        System.out.println("Nic");
    }
}
