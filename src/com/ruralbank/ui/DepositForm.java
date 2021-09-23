package com.ruralbank.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

import com.ruralbank.customer.RegisterCustomer;
import com.ruralbank.deposit.Deposit;

import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DepositForm extends JFrame {

	private JPanel label_1;
	private JTextField CustomerIdTextField;
	private JTextField customerNameTextField;
	private JTextField depositTextField;

	/**
	 * Launch the application.
	 */
	public static void openDeposit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositForm frame = new DepositForm();
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
	public DepositForm() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 689);
		label_1 = new JPanel();
		label_1.setBackground(new Color(255, 204, 153));
		label_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		label_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(label_1);
		label_1.setLayout(null);
		
		JLabel depositNewLabel = new JLabel("DEPOSIT FORM");
		depositNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		depositNewLabel.setBounds(476, 10, 288, 39);
		label_1.add(depositNewLabel);
		
		JLabel customerIdNewLabel = new JLabel("CUSTOMER ID :");
		customerIdNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		customerIdNewLabel.setBounds(249, 149, 204, 35);
		label_1.add(customerIdNewLabel);
		
		JLabel customerrNameNewLabel = new JLabel("CUSTOMER NAME :");
		customerrNameNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		customerrNameNewLabel.setBounds(249, 228, 255, 46);
		label_1.add(customerrNameNewLabel);
		
		JLabel depositAmountNewLabel = new JLabel("AMOUNT :");
		depositAmountNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		depositAmountNewLabel.setBounds(260, 319, 261, 29);
		label_1.add(depositAmountNewLabel);
		
		CustomerIdTextField = new JTextField();
		CustomerIdTextField.setBounds(575, 152, 278, 39);
		label_1.add(CustomerIdTextField);
		CustomerIdTextField.setColumns(10);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(575, 237, 278, 39);
		label_1.add(customerNameTextField);
		customerNameTextField.setColumns(10);
		
		JButton depositNewButton = new JButton("Deposit");
		depositNewButton.setForeground(Color.WHITE);
		depositNewButton.setBackground(new Color(0, 0, 0));
		depositNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			
				if(CustomerIdTextField.getText().isEmpty()||customerNameTextField.getText().isEmpty()||depositTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Data is Missing");
				}
				else {
					if(Integer.parseInt(depositTextField.getText())>0) {
						Deposit deposite = new Deposit();
						boolean depositFlag = deposite.doDeposit(Integer.parseInt(CustomerIdTextField.getText()), customerNameTextField.getText(), Double.parseDouble( depositTextField.getText()));
						if(depositFlag) {
							JOptionPane.showMessageDialog(null, "Amount "+ depositTextField.getText() + " Successfully Deposit in your account !");
							CustomerIdTextField.setText("");
							customerNameTextField.setText("");
							depositTextField.setText("");
							
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
		depositNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		depositNewButton.setBounds(771, 431, 183, 63);
		label_1.add(depositNewButton);
		
		depositTextField = new JTextField();
		depositTextField.setColumns(10);
		depositTextField.setBounds(575, 319, 278, 39);
		label_1.add(depositTextField);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(53, 40, 109, 46);
		label_1.add(btnNewButton);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
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
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAccount.setBackground(Color.BLACK);
		btnAccount.setBounds(177, 40, 143, 46);
		label_1.add(btnAccount);
	}

}
