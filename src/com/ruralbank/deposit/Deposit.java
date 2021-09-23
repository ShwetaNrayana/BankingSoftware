package com.ruralbank.deposit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.ruralbank.account.GetAccount;
import com.ruralbank.customer.GetCustomer;
import com.ruralbank.customer.accounts.Account;

public class Deposit {

	public static boolean doDeposit(int customerId,String name,double depositAmount) {
		ResultSet rs = null;
		int id = 1;
//		int customerId = 1;
//		int accountId = 1;
//		double depositAmount = 874;
		//Timestamp date = (Timestamp) new Date();
		try {
			
			GetCustomer customerObj = new GetCustomer();
			int existsCustomerId = customerObj.getCustomerId(customerId, name);
			if(existsCustomerId!=0) {
				
				GetAccount getAccountObj=new GetAccount();
				Account account = getAccountObj.getAccountDetailsByCustomerId(existsCustomerId);
				if(account!=null){
					
					String sqlQuery = "insert into deposit (id,customerId,ACCOUNTID,created_date,amount) values (?,?,?,?,?)";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// step2 create the connection object
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rural_bank",
							"rural_bank");
					PreparedStatement pstmt = con.prepareStatement(sqlQuery);

					// set parameters for statement
					pstmt.setInt(1, 0);
					pstmt.setInt(2, existsCustomerId);
					pstmt.setInt(3, account.getId());
					pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
					pstmt.setDouble(5, depositAmount);

					int rowAffected = pstmt.executeUpdate();
					if (rowAffected == 1) {
						double latestAmount = depositAmount + account.getAmount();
						getAccountObj.updateAccountByCustomerId(existsCustomerId, latestAmount);
						return true;
					}
					
				} 
			}
		}catch (SQLException | ClassNotFoundException ex) {
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


