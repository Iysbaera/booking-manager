package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;

/**
 */
public class HotelCreateDto {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelCreateDto)) return false;

        final HotelCreateDto hotel = (HotelCreateDto) o;

        return hotel.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        int result;
        result = 31 + ((null == getName()) ? 0 : getName().hashCode());
        return result;
    }
}
