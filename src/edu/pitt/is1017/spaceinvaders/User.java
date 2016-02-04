package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * @author Grant Wescott
 * 
 */



public class User {
	
	LoginGUI lg = new LoginGUI();
	RegistrationGUI rg = new RegistrationGUI(); 
	
	
	private int userID;
	private String lastName, firstName, email, password;
	private boolean loggedIn;
	
	//default constructor
	public User(){
		userID = 1;
		email = "generic@pitt.edu";
		password = "tester123";
	}
	
	//constructor
	public User(int id, String txtEmail, String txtPassword){
		userID = id;
		email = txtEmail;
		password = txtPassword;
	}
	
	public User(int id, String firstName, String lastName, String email, String password){
		
	}
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public static void main(String[] args){
		DbUtilities db = new DbUtilities();
		
		String lastName, firstName, email, password;
		/*
		String sql = "INSERT INTO users (lastName, firstName, email, password)";
		sql = sql + "VALUES('" + lastName + "','" + firstName +"','" + email +"','" + "'MD5('" + password + "'))";
	*/
		//System.out.println(sql);
		
		//db.executeQuery(sql);
		 String sql = "SELECT * FROM users WHERE email = " + email + " AND password = " + password + ";";
		try{
			ResultSet rs = db.getResultSet(sql);
			while (rs.next()){
				System.out.print(rs.getInt("userID") + "\t");
				System.out.print(rs.getString("lastName") + "\t");
				System.out.print(rs.getString("firstName") + "\t");
				System.out.print(rs.getString("email"));
				System.out.println();
			}
		}
		catch(Exception ex){
			//Handle here
		}
	}
	/*private void close(){
		try{
			if (rs != null){
				rs.close();
			}
			if (sql != null){
				sql.close();
			}
			if (db != null){
				db.close();
			}
			}
		catch(Exception e){
			
		}
	}*/
}

