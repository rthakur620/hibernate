package com.hibernate.inheritanceJoinstartegy;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FOURWHEELER_JS")
public class FourWheeler extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
	
}
