package edu.pitt.is1017.spaceinvaders;

public class Tester1 {

	public static void main(String[] args) {
		User user = new User("gew24@pitt.edu", "gew24");
		//System.out.println(user.getLastName());
		ScoreTracker st = new ScoreTracker(user);
		st.topHighScore();
//		st.getHighestScore();
//		st.recordScore(1);
//		st.getGameID();
	}
}