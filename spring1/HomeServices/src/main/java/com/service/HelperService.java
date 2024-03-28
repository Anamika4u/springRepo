package com.service;
 
import org.springframework.stereotype.Service;
 
import com.model.HelperBean;
 
@Service
public class HelperService {
 
	public double calculateTotalCost(HelperBean helperBean) {
 
		float costPerHour = 0;
		switch (helperBean.getServiceType()) {
			case "ACService":
				costPerHour = 400;
				break;
			case "WashingMachineService":
				costPerHour = 500;
				break;
			case "RefrigeratorService":
				costPerHour = 300;
				break;
		}
		helperBean.setServiceCostPerHour(costPerHour);
		double totalCost = costPerHour * helperBean.getNoOfHours();
		return totalCost;
	}
}
 
