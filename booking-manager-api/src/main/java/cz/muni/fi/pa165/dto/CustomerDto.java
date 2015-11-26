package cz.muni.fi.pa165.dto;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Ivo Hradek
 */
public class CustomerDto {
    private Long id;
    private String forename;
    private String surname;
    private Collection<BookingDto> bookings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(Collection<BookingDto> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDto)) return false;

        final CustomerDto customer = (CustomerDto) o;

        return customer.getId().equals(getId())             &&
                customer.getSurname().equals(getSurname())   &&
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
}
