package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrationGUI {

	JFrame frmSpaceinvadersResigstration;
	public JTextField txtFirstName;
	public JTextField txtLastName;
	public JTextField txtEmail;
	public JTextField txtPassword;
	public JTextField txtConfirmPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationGUI window = new RegistrationGUI();
					window.frmSpaceinvadersResigstration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpaceinvadersResigstration = new JFrame();
		frmSpaceinvadersResigstration.setTitle("SpaceInvaders - Resigstration");
		frmSpaceinvadersResigstration.setBounds(100, 100, 574, 414);
		frmSpaceinvadersResigstration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpaceinvadersResigstration.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(85, 63, 138, 16);
		frmSpaceinvadersResigstration.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(85, 102, 138, 16);
		frmSpaceinvadersResigstration.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(85, 149, 44, 16);
		frmSpaceinvadersResigstration.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(85, 192, 138, 16);
		frmSpaceinvadersResigstration.getContentPane().add(lblPassword);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(240, 60, 236, 22);
		frmSpaceinvadersResigstration.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(240, 99, 236, 22);
		frmSpaceinvadersResigstration.getContentPane().add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(240, 146, 236, 22);
		frmSpaceinvadersResigstration.getContentPane().add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(240, 189, 236, 22);
		frmSpaceinvadersResigstration.getContentPane().add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(85, 234, 138, 16);
		frmSpaceinvadersResigstration.getContentPane().add(lblConfirmPassword);
		
		txtConfirmPw = new JTextField();
		txtConfirmPw.setColumns(10);
		txtConfirmPw.setBounds(240, 231, 236, 22);
		frmSpaceinvadersResigstration.getContentPane().add(txtConfirmPw);
		
		// create registration button to open registration GUI
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(246, 298, 97, 25);
		frmSpaceinvadersResigstration.getContentPane().add(btnRegister);
		btnRegister.addActionListener(new BtnRegisterListener());
		
		
		
		//create cancel button to close the window
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(379, 298, 97, 25);
		frmSpaceinvadersResigstration.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new BtnCancelListener());
			}
	    // class to handle cancel button event and close the window
		public class BtnCancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
					
			}
		}
		
		//class to handle Resister button event and register new user
		public class BtnRegisterListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				new User();
				
			}
		}
		
}
