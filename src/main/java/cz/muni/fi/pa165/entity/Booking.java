package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity representing a single booking item in a hotel.
 *
 * @see Room
 * @see Customer
 * @author Ivo Hradek
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long Id;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Room room;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in", nullable = false)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out", nullable = false)
    private Date checkOut;

    // @Formula("")
    // private BigDecimal price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
}
