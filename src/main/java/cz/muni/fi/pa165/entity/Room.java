package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.Enum.RoomType;
import cz.muni.fi.pa165.embeddable.RoomPrice;

import javax.persistence.*;

/***
 * Entity representing a single room.
 * <p>
 * Every room is associated to exactly one hotel. Every room in a single hotel
 * has always its own unique room number. Room is always unavailable only for a
 * range of time determined by check-in and check-out date of concrete
 * customer's booking. So every room is either available or not for another
 * customer's booking.
 * <p>
 * Room's price depends only on its type. There are no specialised services
 * for certain types of rooms.
 *
 * @see Hotel
 * @see RoomType
 * @author Ivo Hradek
 */
@Entity
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "fk_hotel", nullable = false)
    private Hotel hotel;

    @Column(nullable = true, unique = true)
    private int number;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RoomType type;

    @Embedded
    private RoomPrice price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomPrice getPrice() {
        return price;
    }

    public void setPrice(RoomPrice price) {
        this.price = price;
    }
}
