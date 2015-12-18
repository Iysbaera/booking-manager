package cz.muni.fi.pa165.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Data transfer object for creating a <i>booking</i> item.
 *
 * @author Ivo Hradek
 */
public class CreateBookingDto {
    
    @NotNull
    private Long id;
    
    @NotNull
    private Date checkIn;
    
    @NotNull
    private Date checkOut;    
    
    @NotNull
    private Long customerId;
    
    @NotNull
    private Long roomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + ((null == customerId) ? 0 : customerId.hashCode());
        result = 31 * result + ((null == roomId) ? 0 : roomId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBookingDto)) return false;

        final CreateBookingDto booking = (CreateBookingDto) o;

        return booking.getCustomerId().equals(getCustomerId()) &&
                booking.getRoomId().equals(getRoomId());
    }
}
