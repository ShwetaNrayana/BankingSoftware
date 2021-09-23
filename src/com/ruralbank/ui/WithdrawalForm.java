package com.ruralbank.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ruralbank.withdrawal.Withdrawal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WithdrawalForm extends JFrame {

	private JPanel contentPane;
	private JTextField customerNameTextField;
	private JTextField CustomerIdTextField;
	private JTextField withdrawalTextField;

	/**
	 * Launch the application.
	 */
	public static void openWithdrawal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawalForm frame = new WithdrawalForm();
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
	public WithdrawalForm() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1086, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WITHDRAWAL FORM");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		lblNewLabel.setBounds(451, 0, 313, 57);
		contentPane.add(lblNewLabel);
		
		JLabel customerIdNewLabel = new JLabel("CUSTOMER ID :");
		customerIdNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		customerIdNewLabel.setBounds(286, 100, 213, 91);
		contentPane.add(customerIdNewLabel);
		
		JLabel customerNameNewLabel = new JLabel("CUSTOMER NAME :");
		customerNameNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		customerNameNewLabel.setBounds(286, 213, 245, 69);
		contentPane.add(customerNameNewLabel);
		
		JLabel withdrawalAmountlNewLabel = new JLabel("AMOUNT :");
		withdrawalAmountlNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		withdrawalAmountlNewLabel.setBounds(292, 322, 257, 48);
		contentPane.add(withdrawalAmountlNewLabel);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(559, 229, 296, 48);
		contentPane.add(customerNameTextField);
		customerNameTextField.setColumns(10);
		
		JButton withdrawalNewButton = new JButton("Withdrawal");
		withdrawalNewButton.setForeground(Color.WHITE);
		withdrawalNewButton.setBackground(new Color(0, 0, 0));
		withdrawalNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				
				if(CustomerIdTextField.getText().isEmpty()||customerNameTextField.getText().isEmpty()||withdrawalTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Data is Missing");
				}
				else {
					if(Integer.parseInt(withdrawalTextField.getText())>0) {
						
						Withdrawal withdrawalObj = new Withdrawal();
						boolean withdrawalFlag = withdrawalObj.doWithdrawal(Integer.parseInt(CustomerIdTextField.getText()), customerNameTextField.getText(), Double.parseDouble(withdrawalTextField.getText()));
						
						if(withdrawalFlag) {
							JOptionPane.showMessageDialog(null, "Amount "+ withdrawalTextField.getText() + " Successfully withdrawal from your account !");
							CustomerIdTextField.setText("");
							customerNameTextField.setText("");
							withdrawalTextField.setText("");
							
						}else {
							JOptionPane.showMessageDialog(null, "Customer/Account Doesn't Exists !");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Amount should be more than zero!!");
							
					}
					
				}
			
			
			}
		});
		withdrawalNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		withdrawalNewButton.setBounds(749, 423, 171, 56);
		contentPane.add(withdrawalNewButton);
		
		CustomerIdTextField = new JTextField();
		CustomerIdTextField.setColumns(10);
		CustomerIdTextField.setBounds(559, 127, 296, 48);
		contentPane.add(CustomerIdTextField);
		
		withdrawalTextField = new JTextField();
		withdrawalTextField.setColumns(10);
		withdrawalTextField.setBounds(559, 328, 296, 48);
		contentPane.add(withdrawalTextField);
		
		JButton btnHomeButton = new JButton("Home");
		btnHomeButton.setBackground(new Color(0, 0, 0));
		btnHomeButton.setForeground(Color.WHITE);
		btnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
			
			}
		});
		btnHomeButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnHomeButton.setBounds(39, 34, 110, 44);
		contentPane.add(btnHomeButton);
		
		JButton accountButton = new JButton("Account");
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CustomerAccountDetails frame = new CustomerAccountDetails();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		accountButton.setForeground(Color.WHITE);
		accountButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		accountButton.setBackground(Color.BLACK);
		accountButton.setBounds(159, 34, 147, 44);
		contentPane.add(accountButton);
	}

}
