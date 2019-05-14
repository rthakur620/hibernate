package com.hibernate.inheritanceTablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FOURWHEELER_TBC")
public class FourWheeler extends Vehicle {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
	
}
