package com.ruralbank.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetCustomer {

	public static int getCustomerId(int customerId,String customerName) {
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");

			// step3 create the statement object
			PreparedStatement pstmt = con.prepareStatement("select Id from customer_details where Id=? and UPPER(NAME) = ? ");
		
			pstmt.setInt(1, customerId);
			pstmt.setString(2, customerName.toUpperCase());

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				return rs.getInt(1);
			}

			// step5 close the connection object
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	} 
	
	public static boolean getCustomerByMobPanAadhar(String mobile , String  pan,String aadhar) {
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");

			// step3 create the statement object
			PreparedStatement pstmt = con.prepareStatement("select * from customer_details where mobile_num =? OR pan=? OR ADHAR = ? ");
		
			pstmt.setString(1, mobile);
			pstmt.setString(2, pan);
			pstmt.setString(3, aadhar);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				return true;
			}

			// step5 close the connection object
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	} 
	
	

}
