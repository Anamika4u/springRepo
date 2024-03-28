package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.bo.TournamentBO;
import com.spring.exception.UnavailableGameException;
import com.spring.model.Tournament;

//use appropriate annotation to make this class as component class
@Component
public class TournamentService {

	private TournamentBO tournamentBO;

	//Use appropriate annotation
	@Autowired
	public TournamentService(TournamentBO tournamentBO) {
		super();
		this.tournamentBO = tournamentBO;
	}

	public TournamentBO getTournamentBO() {
		return tournamentBO;
	}

	public void setTounamentBO(TournamentBO tournamentBO) {
		this.tournamentBO = tournamentBO;
	}

	public void calculateEntryFeeRevenue(Tournament tournamentObj) throws UnavailableGameException {
		// fill the code
		if(tournamentObj.getGameDetails().containsKey(tournamentObj.getGameName())) {
			double entryFee=tournamentBO.calculateEntryFeeRevenue(tournamentObj);
			tournamentObj.calculatePrizeMoney(entryFee);
		}
		else {
			throw new UnavailableGameException("This game is not available");
		}
		
	}
}