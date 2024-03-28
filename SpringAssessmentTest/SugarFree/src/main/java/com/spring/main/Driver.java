package com.spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.ApplicationConfig;
import com.spring.exception.UnavailableGameException;
import com.spring.model.Tournament;
import com.spring.service.TournamentService;

public class Driver {

	public static void main(String[] args) {
		// Fill the code
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Tournament tournament1 = context.getBean(Tournament.class);
		Tournament tournament2 = context.getBean(Tournament.class);
		TournamentService tournamentService = context.getBean(TournamentService.class);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tournament 1 details");
		System.out.println("Enter the game name");
		String gameName1 = sc.nextLine();
		System.out.println("Enter the number of participants");
		int noOfParticipants1 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Tournament 2 details");
		System.out.println("Enter the game name");
		String gameName2 = sc.nextLine();
		System.out.println("Enter the number of participants");
		int noOfParticipants2 = sc.nextInt();
		
		tournament1.setGameName(gameName1);
		tournament1.setNoOfParticipants(noOfParticipants1);
		
		tournament2.setGameName(gameName2);
		tournament2.setNoOfParticipants(noOfParticipants2);
		try {
			tournamentService.calculateEntryFeeRevenue(tournament1);
			System.out.println("Prize money for the "+tournament1.getGameName()+" tournament is $"+tournament1.getPrizeMoney());
		}
		catch(UnavailableGameException e) {
			e.getMessage();
	    }
		try {
			tournamentService.calculateEntryFeeRevenue(tournament2);
			System.out.println("Prize money for the "+tournament2.getGameName()+" tournament is $"+tournament2.getPrizeMoney());
		}
		catch(UnavailableGameException e) {
			e.getMessage();
		}
		finally {
			sc.close();
		}
	}

}
