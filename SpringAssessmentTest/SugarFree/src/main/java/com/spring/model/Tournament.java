package com.spring.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//pojo class with required attributes,getters and setters 
//use appropriate annotation to make this class as component class
// use appropriate annotation for scope
@Component
@Scope("prototype")
public class Tournament implements GamingTournament {

	private String gameName;
	private int noOfParticipants;
	private double prizeMoney;

	// use appropriate annotation
	@Value("#{${gameDetails.map}}")
	private Map<String, Double> gameDetails;

	// use appropriate annotation
	@Value("${percentage}")
	private double percentage;

	
    public Tournament() {
		super();
		
	}

	

	public String getGameName() {
		return gameName;
	}



	public void setGameName(String gameName) {
		this.gameName = gameName;
	}



	public int getNoOfParticipants() {
		return noOfParticipants;
	}



	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}



	public double getPrizeMoney() {
		return prizeMoney;
	}



	public void setPrizeMoney(double prizeMoney) {
		this.prizeMoney = prizeMoney;
	}



	public Map<String, Double> getGameDetails() {
		return gameDetails;
	}



	public void setGameDetails(Map<String, Double> gameDetails) {
		this.gameDetails = gameDetails;
	}



	public double getPercentage() {
		return percentage;
	}



	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}



	public void calculatePrizeMoney(double entryFeeRevenue) {
		// fill the code
		prizeMoney = entryFeeRevenue*percentage/100;
	}
}
