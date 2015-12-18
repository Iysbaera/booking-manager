package cz.muni.fi.pa165.dto;

import cz.muni.fi.pa165.enumeration.RoomType;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *  Data transfer object for creating a Room item.
 * 
 * @author Jana Cechackova
 */
public class CreateRoomDto {
    @NotNull
    private int number;

    @NotNull
    private Long hotelId;
    @NotNull
    private RoomType roomType;

    @NotNull
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void setHotelId(Long id){this.hotelId = id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateRoomDto)) return false;

        final CreateRoomDto room = (CreateRoomDto) o;

        return room.getNumber()==(getNumber());
    }

    @Override
    public int hashCode() {
        System.out.println("");
        return this.getNumber()+hotelId.hashCode();
    }


}
