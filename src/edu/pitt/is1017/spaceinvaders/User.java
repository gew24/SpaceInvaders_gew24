package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * @author Grant Wescott
 * 
 */



public class User {
	private int userID;
	private String lastName, firstName, email, password;
	private boolean loggedIn;
	
	//default constructor
	public User(int userID){
		userID = 1;
		email = "generic@pitt.edu";
		password = "tester123";
	}
	
	public int getUserID() {
		return userID;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	//constructor to login user
	public User(String txtEmail, String txtPassword){
		DbUtilities db = new DbUtilities();
		// gather data from LoginGUI
		String email = txtEmail;
		String password = txtPassword;
		
		// sql statement to query db for email and password
		String sql = "SELECT * FROM users WHERE email = '" + email +  "' AND password = MD5('" + password + "');";

		// try catch block test input against database to validate user credentials
		try{
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()){
				loggedIn = true;
				JOptionPane.showMessageDialog(null, "Congratulations! You are logged in." + email + password);
			}
			else{ 
				loggedIn = false;
				JOptionPane.showMessageDialog(null, "Login attempt failed.");
			}
		}
		catch(Exception ex){	
		}
	}
	
	// constructor to register new user 
	public User(String lastName, String firstName, String email, String password){
		DbUtilities db = new DbUtilities();
		
		String sql = "INSERT INTO users (lastName, firstName, email, password)";//Insert statement
		sql = sql + "VALUES('" + lastName + "','" + firstName +"','" + email +"'," + "MD5('" + password + "'))";
		System.out.println(sql);
		db.executeQuery(sql);
	}
}