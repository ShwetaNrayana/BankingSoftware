package com.ruralbank.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ruralbank.account.AddAccount;

public class RegisterCustomer {

	public static boolean register(String name,String mobile,String aadhar,String pan,String gender,String postalAdd,int pin) {

		ResultSet rs = null;
/*//		int id = 34;
//		String name = "twin";
//		int mobileNumber = 91236;
//		int aadhar = 3356226;
//		String pan = "ASB345";
//		String gender = "Female";
//		String postalAdd = "Marathahalli";
//		int pin = 560037;
*/
		try {
			String sqlQuery = "insert into customer_details (id,name,mobile_num,adhar,pan,gender,postal_add,pin) values "
					+ "(?,?,?,?,?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String generatedColumns[] = { "ID" };

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");
			PreparedStatement pstmt = con.prepareStatement(sqlQuery, generatedColumns);

			// set parameters for statement
			pstmt.setInt(1, 0);
			pstmt.setString(2, name);
			pstmt.setString(3, mobile);
			pstmt.setString(4, aadhar);
			pstmt.setString(5, pan);
			pstmt.setString(6, gender);
			pstmt.setString(7, postalAdd);
			pstmt.setInt(8, pin);

			int custId = 0;

			int rowAffected = pstmt.executeUpdate();
			if (rowAffected == 1) {
				// get candidate id
				rs = pstmt.getGeneratedKeys();
				rs.next();
				custId = rs.getInt(1);
				AddAccount accountObj=new AddAccount();
				accountObj.openAccount(custId);
				return true;
			}
			System.out.println(custId);
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

}
