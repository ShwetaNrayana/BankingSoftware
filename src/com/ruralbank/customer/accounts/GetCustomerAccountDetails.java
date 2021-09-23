package com.ruralbank.customer.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetCustomerAccountDetails {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
					"rural_bank");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select cust.id as customerID,acc.id as accountId,cust.name,"
					+ "cust.mobile_num,adhar,pan,Gender,postal_add,pin,created_date,amount from customer_details cust join accounts acc on cust.id=acc.customerId");
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

}
