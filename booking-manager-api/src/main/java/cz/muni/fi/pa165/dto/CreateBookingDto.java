package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;

/**
 * Data transfer object for creating a <i>booking</i> item.
 *
 * @author Ivo Hradek
 */
public class CreateBookingDto {

    @NotNull
    private Long customerId;
    @NotNull
    private Long roomId;

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
