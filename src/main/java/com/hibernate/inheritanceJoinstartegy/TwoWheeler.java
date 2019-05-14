package com.hibernate.inheritanceJoinstartegy;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TWOWHEELER_JS")
public class TwoWheeler extends Vehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
}
