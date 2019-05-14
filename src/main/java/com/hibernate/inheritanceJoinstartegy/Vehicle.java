package com.hibernate.inheritanceJoinstartegy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_JS")
@Inheritance(strategy=InheritanceType.JOINED)  
public class Vehicle {

	@Id @GeneratedValue
	private int vehicleId;
	private String vehiclaName;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehiclaName() {
		return vehiclaName;
	}
	public void setVehiclaName(String vehiclaName) {
		this.vehiclaName = vehiclaName;
	}
	
	
	
}
