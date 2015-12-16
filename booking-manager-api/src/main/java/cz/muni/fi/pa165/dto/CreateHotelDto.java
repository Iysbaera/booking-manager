package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Data transfer object for creating a <i>hotel</i> item.
 *
 * @author Ivo Hradek
 */
public class CreateHotelDto {
    @NotNull
    @Size(min = 3, max = 50)
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
        if (!(o instanceof CreateHotelDto)) return false;

        final CreateHotelDto hotel = (CreateHotelDto) o;

        return hotel.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        int result;
        result = 31 + ((null == getName()) ? 0 : getName().hashCode());
        return result;
    }
}
