package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.customer.Phone;

public class PhoneDAO {

	public Set<Phone> getPhones(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Phone> phones = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE customerID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String type = resultSet.getString("type");
				String phoneNumber = resultSet.getString("phoneNumber");
				Phone phone = new Phone();
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
				Phone currentPhone = phoneIterator.next();
				
				String insertQuery = "INSERT INTO * phone (customerID, type,phoneNumber)"
						+ "VALUES('"+id+"','"+currentPhone.getType()+"','"+currentPhone.getPhoneNumber()+"')";
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

	public void deletePhone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM phone WHERE customerID='"+id+"')";
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
	
	public void updatePhone(String id, Set<Phone> phones) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Phone> phoneIterator = phones.iterator();
			
			while(phoneIterator.hasNext()) {
				Phone currentPhone = phoneIterator.next();
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', city='"+currentPhone.getPhoneNumber()+"'  WHERE customerID='"+id+"')";
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
