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
		// sql statement to query db for email and password
		String sql = "SELECT * FROM users WHERE email = " + email + " AND password = MD5(" + password + ");";//database select statement
		
		ResultSet rs = db.getResultSet(sql);
		// try catch block to capture and compare result set against input
		try {
			if(rs.next()){
				//set all user properties equal to properties from database
				this.userID = rs.getInt("userID");
				this.lastName = rs.getString("lastName");
				this.firstName = rs.getString("firstName");
				this.email = rs.getString("email");
				this.password = rs.getString("password");
				
				try{
					
					while (rs.next()){
						System.out.print(rs.getInt("userID") + "\t");
						System.out.print(rs.getString("lastName") + "\t");
						System.out.print(rs.getString("firstName") + "\t");
						System.out.print(rs.getString("email"));
						System.out.println();
						

						while(this.email == rs.getString("email")){			
							if(this.password != rs.getString("MD5(password)")){
								loggedIn = false;
							}
							else{
								
								loggedIn = true;
							}		
						}
					}
					JOptionPane.showMessageDialog(null, "You are logged in");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,"connection failed");
				}
				
			}									
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}			
		try{
			if(rs != null){
			rs.close();
			}
		}
		catch(Exception e){
				
		}
		if(loggedIn = true){

			JOptionPane.showMessageDialog(null,"You are now logged in.");	
		}
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