package com.ruralbank.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class CustomerAccountDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnHomeButton;
	private JLabel lblNewLabel;
	private JTextField cid_accid;
	private JButton btnNewButton;
	private JTextField mob_pan_aa;

	/**
	 * Launch the application.
	 */
	public static void openCustomerAccount() {
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

	/**
	 * Create the frame.
	 */
	public CustomerAccountDetails() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadData = new JButton("Load Accounts");
		btnLoadData.setForeground(Color.WHITE);
		btnLoadData.setBackground(new Color(0, 0, 0));
		btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					// step2 create the connection object
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
							"rural_bank");

					// step3 create the statement object
					Statement stmt = con.createStatement();

					// step4 execute query
					ResultSet rs = stmt.executeQuery("select cust.id as customerID,acc.id as accountId,cust.name,"
							+ "cust.mobile_num,adhar,pan,Gender,postal_add,pin,amount from customer_details cust join accounts acc on cust.id=acc.customerId");
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnLoadData.setBounds(814, 23, 199, 46);
		contentPane.add(btnLoadData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 112, 742, 417);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnHomeButton = new JButton("Home");
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
		btnHomeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHomeButton.setBounds(55, 23, 121, 40);
		contentPane.add(btnHomeButton);
		
		lblNewLabel = new JLabel("Customer Id / Account Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 88, 172, 21);
		contentPane.add(lblNewLabel);
		
		cid_accid = new JTextField();
		cid_accid.setBounds(35, 118, 185, 31);
		contentPane.add(cid_accid);
		cid_accid.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!mob_pan_aa.getText().trim().isEmpty()&& !cid_accid.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter one value at a time to search ");
				}else {
					if(mob_pan_aa.getText().trim().isEmpty() & cid_accid.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter value to search ");
					}
					else {
						
						if(!mob_pan_aa.getText().trim().isEmpty()) {
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");

								// step2 create the connection object
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
										"rural_bank");

								// step3 create the statement object
								PreparedStatement pstmt = con.prepareStatement("select cust.id as customerID,acc.id as accountId,cust.name,"
										+ "cust.mobile_num,adhar,pan,Gender,postal_add,pin,amount from customer_details cust join accounts acc on cust.id=acc.customerId"
										+ " where mobile_num =? OR pan=? OR ADHAR = ?");
										pstmt.setString(1, mob_pan_aa.getText().trim());
										pstmt.setString(2, mob_pan_aa.getText().trim());
										pstmt.setString(3, mob_pan_aa.getText().trim());
								// step4 execute query
										ResultSet rs = pstmt.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
								System.out.println(e1);
							}
							
						}
						if(!cid_accid.getText().trim().isEmpty()) {
							
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");

								// step2 create the connection object
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
										"rural_bank");

								// step3 create the statement object
								PreparedStatement pstmt = con.prepareStatement("select cust.id as customerID,acc.id as accountId,cust.name,"
										+ "cust.mobile_num,adhar,pan,Gender,postal_add,pin,amount from customer_details cust"
										+ " join accounts acc on cust.id=acc.customerId where cust.id = ? OR acc.id = ?");
								
										pstmt.setString(1, cid_accid.getText().trim());
										pstmt.setString(2, cid_accid.getText().trim());
										

										ResultSet rs = pstmt.executeQuery();
								// step4 execute query
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception e1) {
								System.out.println(e1);
							}
													
							}
						
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(135, 230, 85, 31);
		contentPane.add(btnNewButton);
		
		mob_pan_aa = new JTextField();
		mob_pan_aa.setColumns(10);
		mob_pan_aa.setBounds(35, 183, 185, 31);
		contentPane.add(mob_pan_aa);
		
		JLabel lblMobPan = new JLabel("Mob / PAN / Aadhar No.");
		lblMobPan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobPan.setBounds(35, 159, 185, 21);
		contentPane.add(lblMobPan);
	}
}
