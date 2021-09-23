package com.ruralbank.customer.accounts;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AddAccount {

	public static void openAccount(int customerId) {
		 ResultSet rs = null;
			//int id=1;
			//int customerId=20;
			double balance= 0.0;
			// Timestamp date =(Timestamp) new Date();
			try{
				String sqlQuery= "insert into accounts (id,customerId,created_date,amount) values "
					+ "(?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			String generatedColumns[] = { "ID" };

			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","rural_bank","rural_bank"); 
		      PreparedStatement pstmt = con.prepareStatement(sqlQuery,generatedColumns);
		            
		            // set parameters for statement
		            pstmt.setInt(1, 0);
		            pstmt.setInt(2, customerId);
		            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
		            pstmt.setDouble(4, balance);
		            
		            
		            int custId =0;

		            int rowAffected = pstmt.executeUpdate();
		            if(rowAffected == 1)
		            {
		                // get candidate id
		               rs = pstmt.getGeneratedKeys();
		               rs.next();
		               custId= rs.getInt(1);
		            }
		            System.out.println(custId);
		            } catch (SQLException | ClassNotFoundException ex) {
		                ex.printStackTrace();
		            } finally {
		                try {
		                    if(rs != null)  rs.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
				  
				} 

		
	}


