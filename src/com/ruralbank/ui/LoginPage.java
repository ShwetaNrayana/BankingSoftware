package com.ruralbank.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ruralbank.login.AuthenticateUser;
import com.ruralbank.withdrawal.Withdrawal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField passwordTextField;
	private JTextField userTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img= new ImageIcon(this.getClass().getResource("Bank_Back.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(-155, 0, 846, 662);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RURAL BANK");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(799, 10, 210, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel UserNameNewLabel = new JLabel("USERNAME :");
		UserNameNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		UserNameNewLabel.setBounds(701, 181, 137, 26);
		contentPane.add(UserNameNewLabel);
		
		JLabel passwordNewLabel = new JLabel("PASSWORD :");
		passwordNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		passwordNewLabel.setBounds(701, 273, 137, 37);
		contentPane.add(passwordNewLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(848, 274, 214, 41);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		userTextField = new JTextField();
		userTextField.setColumns(10);
		userTextField.setBounds(848, 177, 214, 41);
		contentPane.add(userTextField);
		
		JButton loginNewButton = new JButton("LOGIN");
		loginNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userTextField.getText().isEmpty()||passwordTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Username or password is missing");
				}
				else {
					AuthenticateUser authenticateUser = new AuthenticateUser();
					boolean isExists = authenticateUser.getAllAccount(userTextField.getText(), passwordTextField.getText());
					if(isExists) {
						JOptionPane.showMessageDialog(null, "Welcome !! "+userTextField.getText());
						dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Dashboard frame = new Dashboard();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}else
						JOptionPane.showMessageDialog(null, "The username and password you entered isn't connected to an account!");
							
					}
					
				
			}
		});
		loginNewButton.setForeground(Color.WHITE);
		loginNewButton.setBackground(new Color(0, 0, 0));
		loginNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginNewButton.setBounds(957, 353, 105, 37);
		contentPane.add(loginNewButton);
	}
}
