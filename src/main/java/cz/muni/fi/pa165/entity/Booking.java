package cz.muni.fi.pa165.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity representing a single booking item in a hotel.
 * <p>
 * Booking is made by exactly one customer who books exactly one room for this
 * booking. Booking has check-in and check-out dates. These dates are used
 * to calculate whole price of customer's booking. Calculation is defined by
 * simple formula: number_of_days * room_price.
 * <p>
 * Difference between check-out date and check-in date should be more than
 * one day. So there are not allowed less than 1-day bookings.
 * Hence whole booking price should be non-negative.
 *
 * @see Room
 * @see Customer
 * @author Ivo Hradek
 */
@Entity
public class Booking {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    private Room room;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in", nullable = false)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out", nullable = false)
    private Date checkOut;

    @Formula("SELECT DATEDIFF(check_out, check_in) * price " +
             "FROM Booking " +
             "JOIN Room")
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
