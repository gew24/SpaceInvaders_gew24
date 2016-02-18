package edu.pitt.is1017.spaceinvaders;

import java.util.UUID;

public class ScoreTracker {

	// variables to hold user information
	private int currentScore;
	private int highestScore;
	private String gameID;
	// ScoreTracker method
	public ScoreTracker(int userID){ //constructor:
		
		//Receives a user object (logged in user) as an argument and sets the corresponding class property
		User user = new User();	
		 
		currentScore = 0;//Initializes currentScore to zero
		
		UUID gameID = UUID.randomUUID();//generate random UUIDs
		System.out.println("this is the UUID" + gameID);

		//Retrieves the value of the highest score for any game that the user has ever played (QUERY)
		DbUtilities db = new DbUtilities();
		String sql = "SELECT scoreValue FROM finalscores WHERE fkUserID = '" + userID + "'; ";    
	}
	
	
	
	//RecordScore method
	public void RecordScore(int point){
		
	}
	
	// RecordFinalScore method
	public void recordFinalScore(){
		
	}
}
