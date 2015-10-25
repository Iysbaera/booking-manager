package cz.muni.fi.pa165.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    @GeneratedValue
    private Long Id;
    
    private String name;
    
    public Long getId(){
	return Id;
    }
    
    public void setId(Long Id){
	this.Id = Id;
    }
    
    public String getName(){
	return name;
    }

    public void setName(String name){
	this.name = name;
    }
}
