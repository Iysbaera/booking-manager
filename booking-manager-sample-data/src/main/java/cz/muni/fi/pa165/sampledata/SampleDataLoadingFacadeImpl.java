package cz.muni.fi.pa165.sampledata;

import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Customer;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.enumeration.RoomType;
import cz.muni.fi.pa165.service.BookingService;
import cz.muni.fi.pa165.service.CustomerService;
import cz.muni.fi.pa165.service.HotelService;
import cz.muni.fi.pa165.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of {@link SampleDataLoadingFacade}.
 *
 * @author Ivo Hradek, Jana Cechackova
 * @see SampleDataLoadingFacade
 */
@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;

    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;

    Hotel hotel1;
    Hotel hotel2;

    Booking booking1;
    Booking booking2;
    Booking booking3;
    Booking booking4;

    Customer customer1;
    Customer customer2;
    Customer customer3;


    @Override
    public void loadData() throws IOException, ParseException {

        hotel1 = hotel("Hotel A");
        hotel2 = hotel("Hotel B");

        customer1 = customer("John", "Brown", "john@john.com");
        customer2 = customer("Jenny", "White", "jenny@jenny.com");
        customer3 = customer("Josh", "Black", "johs@black.sk");

        room1 = room(1, new BigDecimal(10), RoomType.SingleRoom, hotel1);
        room2 = room(2, new BigDecimal(10), RoomType.SingleRoom, hotel1);
        room3 = room(3, new BigDecimal(10), RoomType.SingleRoom, hotel1);
        room4 = room(4, new BigDecimal(10), RoomType.SingleRoom, hotel2);
        room5 = room(5, new BigDecimal(20), RoomType.DoubleRoom, hotel2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2017-01-01");
        Date d2 = sdf.parse("2017-01-07");
        Date d3 = sdf.parse("2017-01-05");
        Date d4 = sdf.parse("2017-01-15");
        Date d5 = sdf.parse("2017-01-18");

        booking1 = booking(d1, d2, customer1, room1);
        booking2 = booking(d1, d2, customer2, room2);
        booking3 = booking(d4, d5, customer2, room2);
        booking4 = booking(d3, d4, customer3, room4);

    }

    private Room room(int number, BigDecimal price, RoomType roomType, Hotel hotel) {
        Room room = new Room();
        room.setHotel(hotel);
        room.setNumber(number);
        room.setType(roomType);
        room.setPrice(price);
        roomService.addRoom(room);

        return room;
    }

    private Hotel hotel(String name) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotelService.addHotel(hotel);

        return hotel;
    }

    private Booking booking(Date checkIn, Date checkOut, Customer customer, Room room) {
        Booking booking = new Booking();
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setPrice(new BigDecimal("10"));
        bookingService.addBooking(booking);

        return booking;
    }

    private Customer customer(String forename, String surname, String email) {
        Customer customer = new Customer();
        customer.setForename(forename);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setPassword("adaasdaf");
        customer.setIsAdmin(false);
        customerService.addCustomer(customer);

        return customer;
    }
}
