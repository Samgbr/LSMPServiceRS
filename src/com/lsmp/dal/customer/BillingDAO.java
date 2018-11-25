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
				String shopperProfileID = resultSet.getString("shopperProfileID");
				Bill bill = new Bill();
				bill.setBillID(billID);
				bill.setCreditCardNumber(creditCardNumber);
				bill.setCvv(cvv);
				bill.setExpiryMonth(expiryMonth);
				bill.setExpiryYear(expiryYear);
				bill.setShopperProfileID(shopperProfileID);
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
	
	public Bill getShopperBillingInfo(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Bill bill = new Bill();
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE billID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			String billID = resultSet.getString("billID");
			String creditCardNumber = resultSet.getString("creditCardNumber");
			String shopperProfileID = resultSet.getString("shopperProfileID");
			int cvv = resultSet.getInt("cvv");
			int expiryMonth = resultSet.getInt("expiryMonth");
			int expiryYear = resultSet.getInt("expiryYear");
			
			bill.setBillID(billID);
			bill.setCreditCardNumber(creditCardNumber);
			bill.setCvv(cvv);
			bill.setShopperProfileID(shopperProfileID);
			bill.setExpiryMonth(expiryMonth);
			bill.setExpiryYear(expiryYear);
				
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return bill;
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
				String partnerProfileID = resultSet.getString("partnerProfileID");
				Bill bill = new Bill();
				bill.setBillID(billID);
				bill.setCreditCardNumber(creditCardNumber);
				bill.setCvv(cvv);
				bill.setExpiryMonth(expiryMonth);
				bill.setExpiryYear(expiryYear);
				bill.setPartnerProfileID(partnerProfileID);
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

	public Bill getPartnerBillingInfo(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Bill bill = new Bill();
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from bill WHERE billID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			String billID = resultSet.getString("billID");
			String creditCardNumber = resultSet.getString("creditCardNumber");
			String partnerProfileID = resultSet.getString("partnerProfileID");
			int cvv = resultSet.getInt("cvv");
			int expiryMonth = resultSet.getInt("expiryMonth");
			int expiryYear = resultSet.getInt("expiryYear");
			
			bill.setBillID(billID);
			bill.setCreditCardNumber(creditCardNumber);
			bill.setCvv(cvv);
			bill.setShopperProfileID(partnerProfileID);
			bill.setExpiryMonth(expiryMonth);
			bill.setExpiryYear(expiryYear);
				
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return bill;
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
						+ "VALUES('"+billID+"','"+id+"','"+currentBillInfo.getCreditCardNumber()+"','"+currentBillInfo.getCvv()+"','"+currentBillInfo.getExpiryMonth()+"','"+currentBillInfo.getExpiryYear()+"')";
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
						+ "VALUES('"+billID+"','"+id+"','"+currentBillInfo.getCreditCardNumber()+"','"+currentBillInfo.getCvv()+"','"+currentBillInfo.getExpiryMonth()+"','"+currentBillInfo.getExpiryYear()+"')";
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

	public Bill insertShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Bill bill = new Bill();
		bill.setBillID(bid);
		bill.setCreditCardNumber(creditCardNumber);
		bill.setCvv(cvv);
		bill.setExpiryMonth(expiryMonth);
		bill.setExpiryYear(expiryYear);
		bill.setShopperProfileID(id);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt; */
	
				String insertQuery = "INSERT INTO bill(billID, shopperProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
						+ "VALUES('"+bid+"','"+id+"','"+creditCardNumber+"','"+cvv+"','"+expiryMonth+"','"+expiryYear+"')";
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
		return bill;	
	}
	
	public Bill insertPartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Bill bill = new Bill();
		bill.setBillID(bid);
		bill.setCreditCardNumber(creditCardNumber);
		bill.setCvv(cvv);
		bill.setExpiryMonth(expiryMonth);
		bill.setExpiryYear(expiryYear);
		bill.setPartnerProfileID(id);
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String billID = "BI" + randomInt;*/
	
				String insertQuery = "INSERT INTO bill(billID, partnerProfileID, creditCardNumber, cvv, expiryMonth, expiryYear) "
						+ "VALUES('"+bid+"','"+id+"','"+creditCardNumber+"','"+cvv+"','"+expiryMonth+"','"+expiryYear+"')";
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
		return bill;		
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
	
	public void updateShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE bill SET creditCardNumber='"+creditCardNumber+"', cvv='"+cvv+"', expiryMonth='"+expiryMonth+"',expiryYear='"+expiryYear+"',shopperProfileID='"+id+"'  WHERE billID='"+bid+"'";
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
	
	public void updatePartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE bill SET creditCardNumber='"+creditCardNumber+"', cvv='"+cvv+"', expiryMonth='"+expiryMonth+"',expiryYear='"+expiryYear+"',partnerProfileID='"+id+"'  WHERE billID='"+bid+"'";
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
