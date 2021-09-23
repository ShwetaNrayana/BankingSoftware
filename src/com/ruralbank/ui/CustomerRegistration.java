package com.ruralbank.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ruralbank.customer.GetCustomer;
import com.ruralbank.customer.RegisterCustomer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton otherRadioButton;
	private JButton saveButton;
	private JTextField aadharTextField;
	private JTextField mobileTextField;
	private JTextField panTextField;
	private JTextField addressTextField;
	private JTextField pinTextField;
	private JButton HomeButton;

	/**
	 * Launch the application.
	 */
	public static void openCustomerRegistration() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegistration frame = new CustomerRegistration();
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
	public CustomerRegistration() {
		setBackground(new Color(0, 204, 153));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setForeground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER REGISTRATION FORM");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 26));
		lblNewLabel.setBounds(310, 0, 530, 54);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Arial Black", Font.PLAIN, 20));
		name.setBounds(130, 105, 103, 42);
		contentPane.add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(276, 109, 571, 42);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel mobile = new JLabel("Mobile :");
		mobile.setFont(new Font("Arial Black", Font.PLAIN, 20));
		mobile.setBounds(130, 191, 133, 36);
		contentPane.add(mobile);
		
		JLabel aadhar = new JLabel("Aadhar :");
		aadhar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		aadhar.setBounds(130, 250, 133, 39);
		contentPane.add(aadhar);
		
		JLabel pan = new JLabel("Pan :");
		pan.setFont(new Font("Arial Black", Font.PLAIN, 20));
		pan.setBounds(130, 309, 103, 31);
		contentPane.add(pan);
		
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Arial Black", Font.PLAIN, 20));
		gender.setBounds(130, 370, 113, 43);
		contentPane.add(gender);
		
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Arial Black", Font.PLAIN, 20));
		address.setBounds(130, 423, 120, 40);
		contentPane.add(address);
		
		JLabel pin = new JLabel("Pin :");
		pin.setFont(new Font("Arial Black", Font.PLAIN, 20));
		pin.setBounds(130, 489, 103, 42);
		contentPane.add(pin);
		
		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBackground(new Color(255, 204, 153));
		maleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (maleRadioButton.isSelected()) {
					femaleRadioButton.setSelected(false);
					otherRadioButton.setSelected(false);
				}
			}
		});
		maleRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		maleRadioButton.setBounds(276, 377, 103, 31);
		contentPane.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBackground(new Color(255, 204, 153));
		femaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(femaleRadioButton.isSelected()) {
					maleRadioButton.setSelected(false);
					otherRadioButton.setSelected(false);
					
				}
			}
		});
		femaleRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		femaleRadioButton.setBounds(514, 382, 103, 21);
		contentPane.add(femaleRadioButton);
		
		otherRadioButton = new JRadioButton("Other");
		otherRadioButton.setBackground(new Color(255, 204, 153));
		otherRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(otherRadioButton.isSelected()) {
					maleRadioButton.setSelected(false);
					femaleRadioButton.setSelected(false);
				}
			}
		});
		otherRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		otherRadioButton.setBounds(763, 382, 103, 21);
		contentPane.add(otherRadioButton);
		
		saveButton = new JButton("Save");
		saveButton.setForeground(Color.WHITE);
		saveButton.setBackground(new Color(0, 0, 0));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean genderFlag=true;
				System.out.println(maleRadioButton.isSelected());
				if(maleRadioButton.isSelected()||femaleRadioButton.isSelected()||otherRadioButton.isSelected())
					genderFlag=false;
			
				if(nameTextField.getText().trim().isEmpty()||mobileTextField.getText().trim().isEmpty()||aadharTextField.getText().trim().isEmpty()
						||panTextField.getText().trim().isEmpty()||genderFlag||addressTextField.getText().trim().isEmpty()||pinTextField.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Data is Missing");
				}
				else {
					String gender="";
					if(maleRadioButton.isSelected()) {
						gender="Male";
						}
					else if(femaleRadioButton.isSelected()) {
						gender="Female";
					}
					else if(otherRadioButton.isSelected()) {
						gender="Other";
					}
					
					GetCustomer getCustomer = new GetCustomer();
					boolean isCustomerExists = getCustomer.getCustomerByMobPanAadhar(mobileTextField.getText().trim(),panTextField.getText().trim(),aadharTextField.getText().trim());
					if(isCustomerExists) {
						JOptionPane.showMessageDialog(null, "Customer/Account already exist ! ");
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
					}else {
					RegisterCustomer customerObject=new RegisterCustomer();
					boolean registerFlag = customerObject.register(nameTextField.getText().trim(),mobileTextField.getText().trim(),aadharTextField.getText().trim(),panTextField.getText().trim(),gender,addressTextField.getText(),Integer.parseInt(pinTextField.getText()));
					if(registerFlag) {
						
					JOptionPane.showMessageDialog(null, "Customer Registered Successfully with new Account!!");
					nameTextField.setText("");
					mobileTextField.setText("");
					aadharTextField.setText("");
					panTextField.setText("");
					addressTextField.setText("");
					pinTextField.setText("");
					maleRadioButton.setSelected(false);
					femaleRadioButton.setSelected(false);
					otherRadioButton.setSelected(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Failed to Register");
					}
				}
				}
			}
		});
		saveButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		saveButton.setBounds(785, 566, 230, 61);
		contentPane.add(saveButton);
		
		aadharTextField = new JTextField();
		aadharTextField.setColumns(10);
		aadharTextField.setBounds(276, 250, 571, 42);
		contentPane.add(aadharTextField);
		
		mobileTextField = new JTextField();
		mobileTextField.setColumns(10);
		mobileTextField.setBounds(276, 185, 571, 42);
		contentPane.add(mobileTextField);
		
		panTextField = new JTextField();
		panTextField.setColumns(10);
		panTextField.setBounds(276, 308, 571, 42);
		contentPane.add(panTextField);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(276, 422, 571, 42);
		contentPane.add(addressTextField);
		
		pinTextField = new JTextField();
		pinTextField.setColumns(10);
		pinTextField.setBounds(276, 494, 571, 42);
		contentPane.add(pinTextField);
		
		HomeButton = new JButton("Home");
		HomeButton.setForeground(Color.WHITE);
		HomeButton.setBackground(new Color(0, 0, 0));
		HomeButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		HomeButton.addActionListener(new ActionListener() {
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
		HomeButton.setBounds(36, 24, 103, 36);
		contentPane.add(HomeButton);
	}
}
