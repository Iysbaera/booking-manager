package cz.muni.fi.pa165.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long Id;
    
    private int number;
    
    private int price;
    
    public Long getId(){
	return Id;
    }
    
    public void setId(Long Id){
	this.Id = Id;
    }
    
    public int getPrice(){
	return price;
    }
    
    public void setPrice(int price){
	this.price = price;
    }
    
    public int getNumber(){
	return number;
    }
    
    public void setNumber(int number){
	this.number = number;
    }

}
