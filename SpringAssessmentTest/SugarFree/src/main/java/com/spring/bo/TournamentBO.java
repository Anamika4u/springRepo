package com.spring.bo;

import org.springframework.stereotype.Component;
import com.spring.model.Tournament;

//use appropriate annotation to make this class as component class
@Component
public class TournamentBO{

	public double calculateEntryFeeRevenue(Tournament tournamentObj) {
		double entryFeeRevenue = 0;
		// Fill the code here
		if(tournamentObj.getGameName().equals("FIFA")) {
			entryFeeRevenue=80*tournamentObj.getNoOfParticipants();
		}
		else if(tournamentObj.getGameName().equals("Fishdom")) {
			entryFeeRevenue=120*tournamentObj.getNoOfParticipants();
		}
		else if(tournamentObj.getGameName().equals("Call Of Duty")) {
			entryFeeRevenue=100*tournamentObj.getNoOfParticipants();
		}
		else if(tournamentObj.getGameName().equals("Rising Super Chef")){
			entryFeeRevenue=140*tournamentObj.getNoOfParticipants();
		}
		
		return entryFeeRevenue;
	}
}
