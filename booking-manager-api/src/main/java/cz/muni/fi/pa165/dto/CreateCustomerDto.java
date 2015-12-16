package cz.muni.fi.pa165.dto;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Jana Cechackova
 */
public class CreateCustomerDto {
    
    @NotNull
    private String forename;
    @NotNull
    private String surname;

    public String getCustomerForename() {
        return forename;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public void setCustomerForename(String forename) {
        this.forename = forename;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + ((null == forename) ? 0 : forename.hashCode());
        result = 31 * result + ((null == surname) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBookingDto)) return false;

        final CreateCustomerDto customer = (CreateCustomerDto) o;

        return customer.getCustomerForename().equals(getCustomerForename()) &&
                customer.getSurname().equals(getSurname());
    }
    
}
