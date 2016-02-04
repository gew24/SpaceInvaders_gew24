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
				
				System.out.print(rs.getInt("userID") + "\t");
				System.out.print(rs.getString("lastName") + "\t");
				System.out.print(rs.getString("firstName") + "\t");
				System.out.print(rs.getString("email"));
				System.out.println();
				
				JOptionPane.showConfirmDialog(null, "Welcome to Space Invaders!");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public User(int id, String firstName, String lastName, String email, String password){
		
	}

	/*private void close(){
		try{
			this.conn = null;{
			this.conn.close();
			}
		}
		catch(Exception e){
			
		}
	
	}*/
}
