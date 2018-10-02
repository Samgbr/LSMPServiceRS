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

	public Set<Phone> getPhones(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Phone> phones = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE profileID='"+id+"'";
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
	
	public void insertPhones(String id, Set<Phone> phones) {
		
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
				
				String insertQuery = "INSERT INTO phone(phoneID, profileID, type,phoneNumber) "
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

	public void insertPhone(String id, Phone phone) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt;
				
				String insertQuery = "INSERT INTO phone(phoneID, profileID, type,phoneNumber) "
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


	public void deletePhone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM phone WHERE profileID='"+id+"')";
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
	
	public void updatePhones(String id, Set<Phone> phones) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				Phone currentPhone = phoneIterator.next();
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', city='"+currentPhone.getPhoneNumber()+"'  WHERE profileID='"+id+"')";
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
	
	public void updatePhone(String id, String phoneID, Phone phone) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE phone SET type='"+phone.getType()+"', city='"+phone.getPhoneNumber()+"'  WHERE profileID='"+id+"' AND phoneID='"+phoneID+"')";
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
