package cz.muni.fi.pa165.facade;

import cz.muni.fi.pa165.dto.BookingDto;
import cz.muni.fi.pa165.dto.CreateBookingDto;

import java.util.Collection;

/**
 * Facade for booking operations.
 *
 * @author Ivo Hradek
 */
public interface BookingFacade {

    /**
     * Create booking.
     *
     * @param booking to be created.
     * @return Id of created booking.
     */
    Long createBooking(CreateBookingDto booking);

    /**
     * Delete single booking by its id.
     *
     * @param id of booking to be deleted.
     */
    void cancelBooking(Long id);

    /**
     * Get all bookings in the system.
     *
     * @return Collection of booking DTOs. If there are no bookings
     * then empty collection will be returned.
     */
    Collection<BookingDto> getAllBookings();

    /**
     * Get all bookings belonging to a hotel.
     * Hotel is identified by its id.
     *
     * @param id of hotel of which bookings should be retrieved.
     * @return Collection of booking DTOs. If there are no bookings
     * then empty collection will be returned.
     */
    Collection<BookingDto> getAllHotelBookings(Long id);

    /**
     * Get all bookings for a specific room.
     *
     * @param id of a room.
     * @return Collection of booking DTOs. If there are no bookings
     * then empty collection will be returned.
     */
    Collection<BookingDto> getAllRoomBookings(Long id);

    /**
     * Get single booking by its id.
     *
     * @param id of a booking to be retrieved.
     * @return DTO of founded booking if it is found. Otherwise null.
     */
    BookingDto getBookingById(Long id);
}
