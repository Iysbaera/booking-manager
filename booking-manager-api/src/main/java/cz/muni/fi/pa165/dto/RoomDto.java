package cz.muni.fi.pa165.dto;

import cz.muni.fi.pa165.enumeration.RoomType;

import java.math.BigDecimal;

/**
 * @author Ivo Hradek
 */
public class RoomDto {
    private Long id;
    private HotelDto hotel;
    private RoomType type;
    private int number;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelDto getHotel() {
        return hotel;
    }

    public void setHotel(HotelDto hotel) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomDto)) return false;

        final RoomDto room = (RoomDto) o;

        return room.getId().equals(getId())        &&
                room.getNumber() ==  getNumber()   &&
                room.getType().equals(getType())   &&
                room.getHotel().equals(getHotel()) &&
                room.getPrice().equals(getPrice());
    }

    @Override
    public int hashCode() {
        int result;
        result = getNumber();
        result = 19 * result + getPrice().intValue();
        result = 23 * result + getType().ordinal();
        return result;
    }
}
