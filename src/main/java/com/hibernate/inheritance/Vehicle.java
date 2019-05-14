package com.hibernate.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  // This is optional , bydefault Inheritance strategy type is single table strategy
/*@DiscriminatorColumn(name ="VEHICLE_TYPE",
		discriminatorType=DiscriminatorType.STRING)*/
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
