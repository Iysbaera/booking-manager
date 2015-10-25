package cz.muni.fi.pa165.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long Id;

    private Long roomId;
    
    private Long customerId;
    
    private Timestamp checkIn;
    
    private Timestamp checkOut;
    
    public Long getId(){
	return Id;
    }
    
    public void setId(Long Id){
	this.Id = Id;
    }
    
    public Long getRoomId(){
	return roomId;
    }
    
    public void setRoomId(Long roomId){
	this.roomId = roomId;
    }
    
    public Long getCustomerId(){
	return customerId;
    }
    
    public void setCustomerId(Long customerId){
	this.customerId = customerId;
    }
    
    public Timestamp getCheckIn(){
	return checkIn;
    }
    
    public void setCheckIn(Timestamp checkIn){
	this.checkIn = checkIn;
    }
    
    public Timestamp getCheckOut(){
	return checkOut;
    }
    
    public void setCheckOut(Timestamp checkOut){
	this.checkOut = checkOut;
    }
}
