package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Alien {

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", colour=" + colour + "]";
	}
	
	//If we dont want to save data in database of particular field, make that variable transient usin @Transient annotation.
	
	
	@Id
	private int aid;
	private AlienName aname;
	private String colour;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
	
}
