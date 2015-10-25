package cz.muni.fi.pa165.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long Id;

    private String firstName;
    
    private String lastName;
    
    public Long getId(){
	return Id;
    }
    
    public void setId(Long Id){
	this.Id = Id;
    }
    
    public String getFirstName(){
	return firstName;
    }
    
    public void setFirstName(String firstName){
	this.firstName = firstName;
    }
    
    public String getLastName(){
	return lastName;
    }
    
    public void setLastName(String lastName){
	this.lastName = lastName;
    }
}
