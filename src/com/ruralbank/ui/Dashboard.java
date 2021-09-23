package com.ruralbank.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DashboardNewLabel = new JLabel("WELCOME TO RURAL BANK");
		DashboardNewLabel.setBounds(318, 10, 515, 48);
		DashboardNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		contentPane.add(DashboardNewLabel);
		
		JButton addCustomerNewButton = new JButton("Add Customer & Open Account");
		addCustomerNewButton.setForeground(Color.WHITE);
		addCustomerNewButton.setBackground(new Color(0, 51, 102));
		addCustomerNewButton.setBounds(32, 525, 353, 48);
		addCustomerNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegistration customerObject=new CustomerRegistration();
				dispose();
				customerObject.openCustomerRegistration();
			}
		});
		addCustomerNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(addCustomerNewButton);
		
		JButton showAccountNewButton = new JButton("Show Account");
		showAccountNewButton.setForeground(Color.WHITE);
		showAccountNewButton.setBackground(new Color(0, 51, 102));
		showAccountNewButton.setBounds(406, 525, 215, 48);
		showAccountNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAccountDetails accountObject=new CustomerAccountDetails();
				dispose();
				accountObject.openCustomerAccount();
			}
		});
		showAccountNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(showAccountNewButton);
		
		JButton depositNewButton = new JButton("Deposit");
		depositNewButton.setForeground(Color.WHITE);
		depositNewButton.setBackground(new Color(0, 51, 102));
		depositNewButton.setBounds(643, 525, 194, 48);
		depositNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DepositForm depositObject=new DepositForm();
				depositObject.openDeposit();
			}
		});
		depositNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(depositNewButton);
		
		JButton withdrawalNewButton = new JButton("Withdrawal");
		withdrawalNewButton.setForeground(Color.WHITE);
		withdrawalNewButton.setBackground(new Color(0, 51, 102));
		withdrawalNewButton.setBounds(855, 525, 187, 48);
		withdrawalNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WithdrawalForm withdrawalObject=new WithdrawalForm();
				withdrawalObject.openWithdrawal();
			}
		});
		withdrawalNewButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		contentPane.add(withdrawalNewButton);
		
		JLabel imgNewLabel = new JLabel("");
		ImageIcon img= new ImageIcon(this.getClass().getResource("bank_img.jpg"));
		imgNewLabel.setIcon(img);
		imgNewLabel.setBounds(32, 104, 1010, 385);
		contentPane.add(imgNewLabel);
	}
}
