package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginGUI {

	private JFrame frame;
	public JTextField txtLoginEmail;
	public JTextField txtLoginPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginEmail = new JLabel("Email:");
		lblLoginEmail.setBounds(49, 60, 56, 16);
		frame.getContentPane().add(lblLoginEmail);
		
		JLabel lblLoginPassword = new JLabel("Password:");
		lblLoginPassword.setBounds(45, 113, 81, 16);
		frame.getContentPane().add(lblLoginPassword);
		
		txtLoginEmail = new JTextField();
		txtLoginEmail.setBounds(155, 57, 149, 22);
		frame.getContentPane().add(txtLoginEmail);
		txtLoginEmail.setColumns(10);
		
		txtLoginPassword = new JTextField();
		txtLoginPassword.setBounds(155, 110, 149, 22);
		frame.getContentPane().add(txtLoginPassword);
		txtLoginPassword.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(43, 198, 97, 25);
		frame.getContentPane().add(btnRegister);
		//btnRegister.addActionListener(new BtnRegisterListener());
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(155, 198, 97, 25);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new BtnLoginListener());
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(267, 198, 97, 25);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new BtnCancelListener());
	}
	
	
	public JTextField getTxtEmail() {
		return txtLoginEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtLoginEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtLoginPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtLoginPassword = txtPassword;
	}


	//class to handle Cancel button event
	private class BtnCancelListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	//class to handle Login button event
	private class BtnLoginListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			new User();
			String email = txtLoginEmail.getText();
			String password = txtLoginPassword.getText();
		}
	}
}
