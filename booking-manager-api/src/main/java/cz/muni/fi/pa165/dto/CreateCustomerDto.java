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

    @NotNull
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(o instanceof CreateCustomerDto)) return false;

        final CreateCustomerDto customer = (CreateCustomerDto) o;

        return customer.getForename().equals(getForename()) &&
                customer.getSurname().equals(getSurname());
    }

}
