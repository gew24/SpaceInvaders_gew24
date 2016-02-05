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
	
	//constructor for login 
	public User(String txtEmail, String txtPassword){
		DbUtilities db = new DbUtilities();
		
		String sql = "SELECT * FROM users WHERE email = " + email + " AND password = " + password + ";";//database select statement
		
		ResultSet rs = db.getResultSet(sql);
		
		try {
			if(rs.next()){
				//set all user properties equal to properties from database
				this.userID = rs.getInt("userID");
				this.lastName = rs.getString("lastName");
				this.firstName = rs.getString("firstName");
				this.email = rs.getString("email");
				this.password = rs.getString("password");
				
				if(this.email != rs.getString("email")){
					JOptionPane.showMessageDialog(null,"That Email is not on file.");
					loggedIn = false;
				}
					else{
						if(this.password != rs.getString("password")){
							loggedIn = false;
						}
						else{
							JOptionPane.showMessageDialog(null,"You are now logged in.");
							loggedIn = true;
					}
					
				}
			}						
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}			
/*		try{
			if(conn = null){
			conn.close();
			}
		}
		catch(Exception e){
				
		}
	*/	
	}
	
	
	// constructor for registration
	public User(String lastName, String firstName, String email, String password){
		DbUtilities db = new DbUtilities();
		
		String sql = "INSERT INTO users (lastName, firstName, email, password)";//Insert statement
		sql = sql + "VALUES('" + lastName + "','" + firstName +"','" + email +"'," + "MD5('" + password + "'))";
		System.out.println(sql);
		db.executeQuery(sql);
	}

}