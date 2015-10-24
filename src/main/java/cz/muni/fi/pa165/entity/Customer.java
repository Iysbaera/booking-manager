package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Entity representing a customer.
 *
 * @see Booking
 * @author Ivo Hradek
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String forename;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "customer")
    private Collection<Booking> bookings = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Collection<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Collection<Booking> bookings) {
        this.bookings = bookings;
    }
}
