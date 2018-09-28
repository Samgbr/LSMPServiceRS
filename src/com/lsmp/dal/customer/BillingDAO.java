package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.customer.Bill;

public class BillingDAO {
	
public Set<Bill> getBillingInfos(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Bill> bills = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE customerID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String creditCardNumber = resultSet.getString("creditCardNumber");
				int cvv = resultSet.getInt("cvv");
				int expiryMonth = resultSet.getInt("expiryMonth");
				int expiryYear = resultSet.getInt("expiryYear");
				Bill bill = new Bill();
				bill.setCreditCardNumber(creditCardNumber);
				bill.setCvv(cvv);
				bill.setExpiryMonth(expiryMonth);
				bill.setExpiryYear(expiryYear);
				bills.add(bill);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return bills;
	}

	
public void insertBillingInfos(String id, Set<Bill> bills) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				Bill currentBillInfo = billIterator.next();
				
				String insertQuery = "INSERT INTO * bill (creditCardNumber, cvv, expiryMonth, expiryYear)"
						+ "VALUES('"+id+"','"+currentBillInfo.getCreditCardNumber()+"','"+currentBillInfo.getCvv()+"','"+currentBillInfo.getExpiryMonth()+"','"+currentBillInfo.getExpiryYear()+"')";
				insertStatement.executeUpdate(insertQuery);
				
			}		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
				
	}
	
	public void deleteBillingInfo(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM bill WHERE customerID='"+id+"')";
			deleteStatement.executeUpdate(deleteQuery);	
						
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	public void updateBillingInfos(String id, Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				Bill currentBillInfo = billIterator.next();
				
				String updateQuery = "UPDATE bill SET creditCardNumber='"+currentBillInfo.getCreditCardNumber()+"', cvv='"+currentBillInfo.getCvv()+"', expiryMonth='"+currentBillInfo.getExpiryMonth()+"',expiryYear='"+currentBillInfo.getExpiryYear()+"'  WHERE customerID='"+id+"')";
				updateStatement.executeUpdate(updateQuery);
				
			}			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}

}
