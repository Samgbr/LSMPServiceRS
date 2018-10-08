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
import com.lsmp.mp.customer.Phone;

public class PhoneDAO {

	public Set<Phone> getShopperPhones(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Phone> phones = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE shopperProfileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String phoneID= resultSet.getString("phoneID");
				String type = resultSet.getString("type");
				String phoneNumber = resultSet.getString("phoneNumber");
				Phone phone = new Phone();
				phone.setPhoneID(phoneID);
				phone.setType(type);
				phone.setPhoneNumber(phoneNumber);
				phones.add(phone);
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
		
		return phones;
	}
	
	public Set<Phone> getPartnerPhones(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Phone> phones = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE partnerProfileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String phoneID= resultSet.getString("phoneID");
				String type = resultSet.getString("type");
				String phoneNumber = resultSet.getString("phoneNumber");
				Phone phone = new Phone();
				phone.setPhoneID(phoneID);
				phone.setType(type);
				phone.setPhoneNumber(phoneNumber);
				phones.add(phone);
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
		
		return phones;
	}
	
	public void insertShopperPhones(String id, Set<Phone> phones) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt;*/
				Phone currentPhone = phoneIterator.next(); 
				
				String insertQuery = "INSERT INTO phone(phoneID, shopperProfileID, type,phoneNumber) "
						+ "VALUES('"+currentPhone.getPhoneID()+"','"+id+"','"+currentPhone.getType()+"','"+currentPhone.getPhoneNumber()+"')";
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

	public void insertPartnerPhones(String id, Set<Phone> phones) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt;*/
				Phone currentPhone = phoneIterator.next(); 
				
				String insertQuery = "INSERT INTO phone(phoneID, partnerProfileID, type,phoneNumber) "
						+ "VALUES('"+currentPhone.getPhoneID()+"','"+id+"','"+currentPhone.getType()+"','"+currentPhone.getPhoneNumber()+"')";
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
	
	public void insertShopperPhone(String id, Phone phone) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt;
				
				String insertQuery = "INSERT INTO phone(phoneID, shopperProfileID, type,phoneNumber) "
						+ "VALUES('"+phoneID+"','"+id+"','"+phone.getType()+"','"+phone.getPhoneNumber()+"')";
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
	
	public void insertPartnerPhone(String id, Phone phone) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt;
				
				String insertQuery = "INSERT INTO phone(phoneID, partnerProfileID, type,phoneNumber) "
						+ "VALUES('"+phoneID+"','"+id+"','"+phone.getType()+"','"+phone.getPhoneNumber()+"')";
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


	public void deleteShopperPhone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM phone WHERE shopperProfileID='"+id+"'";
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
	
	public void deletePartnerPhone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM phone WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperPhones(String id, Set<Phone> phones) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				Phone currentPhone = phoneIterator.next();
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', city='"+currentPhone.getPhoneNumber()+"'  WHERE shopperProfileID='"+id+"'";
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
	
	public void updatePartnerPhones(String id, Set<Phone> phones) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				Phone currentPhone = phoneIterator.next();
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', city='"+currentPhone.getPhoneNumber()+"'  WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperPhone(String id, String phoneID, Phone phone) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE phone SET type='"+phone.getType()+"', city='"+phone.getPhoneNumber()+"'  WHERE shopperProfileID='"+id+"' AND phoneID='"+phoneID+"'";
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
	
	public void updatePartnerPhone(String id, String phoneID, Phone phone) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE phone SET type='"+phone.getType()+"', city='"+phone.getPhoneNumber()+"'  WHERE partnerProfileID='"+id+"' AND phoneID='"+phoneID+"'";
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
