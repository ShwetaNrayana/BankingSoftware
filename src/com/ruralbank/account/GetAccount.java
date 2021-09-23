package com.ruralbank.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ruralbank.customer.accounts.Account;

public class GetAccount {

	public static void getAllAccount() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select * from accounts");
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "  " + rs.getInt(2) + " "+ rs.getTimestamp(3) + " " + rs.getDouble(4) + " " );

			// step5 close the connection object
			con.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
public static Account getAccountDetailsByCustomerId(int customerId) {
		
		try {
		// step1 load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// step2 create the connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
				"rural_bank");

		// step3 create the statement object
		PreparedStatement pstmt = con.prepareStatement("select * from accounts where customerId=?");
	
		pstmt.setInt(1, customerId);
		

		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Account accountObject= new Account();
			accountObject.setId(rs.getInt(1));
			accountObject.setCustomerId(rs.getInt(2));
			accountObject.setCreatedDate(rs.getTimestamp(3));
			accountObject.setAmount(rs.getInt(4));
			return accountObject;
		}
		

		// step5 close the connection object
		con.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
			
	return null;
}

public boolean updateAccountByCustomerId(int customerId,double amount) {
	
	try {
	// step1 load the driver class
	Class.forName("oracle.jdbc.driver.OracleDriver");

	// step2 create the connection object
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
			"rural_bank");

	// step3 create the statement object
	PreparedStatement pstmt = con.prepareStatement("update accounts set amount=? where customerid=?");

	pstmt.setDouble(1, amount);
	pstmt.setInt(2, customerId);
	

	int rowAffected = pstmt.executeUpdate();
	
	if (rowAffected == 1) {
		return true;
	}
	
	// step5 close the connection object
	con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
	}

		
return false;
}


}
