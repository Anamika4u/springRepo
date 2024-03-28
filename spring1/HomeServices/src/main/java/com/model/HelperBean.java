package com.model;

import org.springframework.stereotype.Component;

@Component
public class HelperBean {
	
	@Override
	public String toString() {
		return "HelperBean [serviceType=" + serviceType + ", serviceCostPerHour=" + serviceCostPerHour + ", noOfHours="
				+ noOfHours + "]";
	}
	private String serviceType;

	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public float getServiceCostPerHour() {
		return serviceCostPerHour;
	}
	public void setServiceCostPerHour(float serviceCostPerHour) {
		this.serviceCostPerHour = serviceCostPerHour;
	}
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	private float serviceCostPerHour;
	private int noOfHours;
	
	

}
