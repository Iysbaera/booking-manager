package cz.muni.fi.pa165.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ivo Hradek
 */
public class BookingDto {
    private Long id;
    private CustomerDto customer;
    private RoomDto room;
    private Date checkIn;
    private Date checkOut;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int result;
        result = (null == getCustomer()) ? 0 : getCustomer().hashCode();
        result = 19 * result + ((null == getRoom()) ? 0 : getRoom().hashCode());
        result = 23 * result + getCheckIn().hashCode();
        result = 29 * result + getCheckOut().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingDto)) return false;

        final BookingDto booking = (BookingDto) o;

        return booking.getId().equals(getId())              &&
                booking.getRoom().equals(getRoom())         &&
                booking.getCheckIn().equals(getCheckIn())   &&
                booking.getCheckOut().equals(getCheckOut()) &&
                booking.getCustomer().equals(getCustomer());
    }
}
