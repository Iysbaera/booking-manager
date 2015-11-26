package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.entity.Booking;
import cz.muni.fi.pa165.entity.Hotel;
import cz.muni.fi.pa165.entity.Room;
import cz.muni.fi.pa165.service.BookingService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link cz.muni.fi.pa165.facade.BookingFacade} interface
 *
 * @see cz.muni.fi.pa165.facade.BookingFacade
 * @author Ivo Hradek
 */
@Transactional
@Service("bookingFacade")
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    BookingService bookingService;

    @Autowired
    Mapper mapper;

    @Override
    public BookingDto getBookingById(Long id) {
        return mapper.map(bookingService.getBookingById(id), BookingDto.class);
    }

    @Override
    public Collection<BookingDto> getAllRoomBookings(Room room) {
        return (Collection) ((List<Booking>) bookingService.getAllBookings()).stream()
                .filter(b -> b.getRoom().getId() == room.getId())
                .map(b -> mapper.map(b, BookingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<BookingDto> getAllHotelBookings(Hotel hotel) {
        return (Collection) ((List<Booking>) bookingService.getAllBookings()).stream()
                .filter(b -> b.getRoom().getHotel().getId() == hotel.getId())
                .map(b -> mapper.map(b, BookingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<BookingDto> getAllBookings() {
        return (Collection) ((List) bookingService.getAllBookings()).stream()
                .map(b -> mapper.map(b, BookingDto.class))
                .collect(Collectors.toList());
    }
}
