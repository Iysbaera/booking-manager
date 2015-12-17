package cz.muni.fi.pa165.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Entity representing a customer.
 * <p/>
 * Every customer has forename and surname. Customer is able to make one or
 * more bookings in the hotels.
 *
 * @author Ivo Hradek
 * @see Booking
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String forename;

    @NotEmpty
    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.REMOVE})
    private Collection<Booking> bookings = new HashSet<>();

    public Long getId() {
        return id;
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
        return Collections.unmodifiableCollection(bookings);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        final Customer customer = (Customer) o;

        return customer.getId().equals(getId()) &&
                customer.getSurname().equals(getSurname()) &&
                customer.getBookings().equals(getBookings()) &&
                customer.getForename().equals(getForename());
    }

    @Override
    public int hashCode() {
        int result;
        result = (null == getForename()) ? 0 : getForename().hashCode();
        result = 19 * result + ((null == getSurname()) ? 0 : getSurname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
