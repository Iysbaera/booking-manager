package cz.muni.fi.pa165.dto;

import java.util.Collection;

/**
 * @author Ivo Hradek
 */
public class HotelDto {
    private Long id;
    private String name;
    private Collection<RoomDto> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<RoomDto> rooms) {
        this.rooms = rooms;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelDto)) return false;

        final HotelDto hotel = (HotelDto) o;

        return hotel.getId().equals(getId()) &&
                hotel.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        int result;
        result = 31 + ((null == getName()) ? 0 : getName().hashCode());
        return result;
    }
}
