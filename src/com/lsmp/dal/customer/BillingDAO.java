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
	
public Set<Bill> getShopperBillingInfos(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Bill> bills = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE shopperProfileID='"+id+"'";
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

	public Set<Bill> getPartnerBillingInfos(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Bill> bills = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE partnerProfileID='"+id+"'";
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

	
public void insertShopperBillingInfos(String id, Set<Bill> bills) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
				
				Bill currentBillInfo = billIterator.next();
				
				String insertQuery = "INSERT INTO bill(billID, shopperProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
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


	public void insertPartnerBillingInfos(String id, Set<Bill> bills) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
				
				Bill currentBillInfo = billIterator.next();
				
				String insertQuery = "INSERT INTO bill(billID, partnerProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
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

	public void insertShopperBillingInfo(String id, Bill bill) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
	
				String insertQuery = "INSERT INTO bill(billID, shopperProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
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
	
	public void insertPartnerBillingInfo(String id, Bill bill) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;
	
				String insertQuery = "INSERT INTO bill(billID, partnerProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
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
	
	public void deleteShopperBillingInfo(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM bill WHERE shopperProfileID='"+id+"'";
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
	public void deletePartnerBillingInfo(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM bill WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperBillingInfos(String id, Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				Bill currentBillInfo = billIterator.next();
				
				String updateQuery = "UPDATE bill SET creditCardNumber='"+currentBillInfo.getCreditCardNumber()+"', cvv='"+currentBillInfo.getCvv()+"', expiryMonth='"+currentBillInfo.getExpiryMonth()+"',expiryYear='"+currentBillInfo.getExpiryYear()+"'  WHERE shopperProfileID='"+id+"'";
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
	
	public void updatePartnerBillingInfos(String id, Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Bill> billIterator = bills.iterator();
			
			while(billIterator.hasNext()) {
				Bill currentBillInfo = billIterator.next();
				
				String updateQuery = "UPDATE bill SET creditCardNumber='"+currentBillInfo.getCreditCardNumber()+"', cvv='"+currentBillInfo.getCvv()+"', expiryMonth='"+currentBillInfo.getExpiryMonth()+"',expiryYear='"+currentBillInfo.getExpiryYear()+"'  WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperBillingInfo(String id, String billID, Bill bill) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE bill SET creditCardNumber='"+bill.getCreditCardNumber()+"', cvv='"+bill.getCvv()+"', expiryMonth='"+bill.getExpiryMonth()+"',expiryYear='"+bill.getExpiryYear()+"'  WHERE shopperProfileID='"+id+"' AND billID='"+billID+"'";
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
	
	public void updatePartnerBillingInfo(String id, String billID, Bill bill) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE bill SET creditCardNumber='"+bill.getCreditCardNumber()+"', cvv='"+bill.getCvv()+"', expiryMonth='"+bill.getExpiryMonth()+"',expiryYear='"+bill.getExpiryYear()+"'  WHERE partnerProfileID='"+id+"' AND billID='"+billID+"'";
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
