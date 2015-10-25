package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.enumeration.RoomType;

import javax.persistence.*;
import java.math.BigDecimal;

/**
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_hotel", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RoomType type;

    @Column(nullable = true, unique = true)
    private int number;

    @Column(nullable = true)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
