package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.customer.Bill;

public class BillingDAO {
	
public Set<Bill> getBillingInfos(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Bill> bills = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE profileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String billID = resultSet.getString("billID");
				String creditCardNumber = resultSet.getString("creditCardNumber");
				int cvv = resultSet.getInt("cvv");
				int expiryMonth = resultSet.getInt("expiryMonth");
				int expiryYear = resultSet.getInt("expiryYear");
				Bill bill = new Bill();
				bill.setBillID(billID);
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
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
				
				Bill currentBillInfo = billIterator.next();
				
				String insertQuery = "INSERT INTO bill(billID, profileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
						+ "VALUES('"+currentBillInfo.getBillID()+"','"+id+"','"+currentBillInfo.getCreditCardNumber()+"','"+currentBillInfo.getCvv()+"','"+currentBillInfo.getExpiryMonth()+"','"+currentBillInfo.getExpiryYear()+"')";
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

	public void insertBillingInfo(String id, Bill bill) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
	
				String insertQuery = "INSERT INTO bill(billID, profileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
						+ "VALUES('"+billID+"','"+id+"','"+bill.getCreditCardNumber()+"','"+bill.getCvv()+"','"+bill.getExpiryMonth()+"','"+bill.getExpiryYear()+"')";
				insertStatement.executeUpdate(insertQuery);
			
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
			
			String deleteQuery = "DELETE FROM bill WHERE profileID='"+id+"')";
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
				
				String updateQuery = "UPDATE bill SET creditCardNumber='"+currentBillInfo.getCreditCardNumber()+"', cvv='"+currentBillInfo.getCvv()+"', expiryMonth='"+currentBillInfo.getExpiryMonth()+"',expiryYear='"+currentBillInfo.getExpiryYear()+"'  WHERE profileID='"+id+"')";
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
	
	public void updateBillingInfo(String id, String billID, Bill bill) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE bill SET creditCardNumber='"+bill.getCreditCardNumber()+"', cvv='"+bill.getCvv()+"', expiryMonth='"+bill.getExpiryMonth()+"',expiryYear='"+bill.getExpiryYear()+"'  WHERE profileID='"+id+"' AND billID='"+billID+"')";
			updateStatement.executeUpdate(updateQuery);			
			
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
