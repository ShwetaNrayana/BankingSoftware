package com.ruralbank.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ruralbank.customer.accounts.Account;

public class AuthenticateUser {

	public static boolean getAllAccount(String username,String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			PreparedStatement pstmt = con.prepareStatement("select Id from rbl_user where USER_NAME=? and PASSWORD = ? ");
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				return true;
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
