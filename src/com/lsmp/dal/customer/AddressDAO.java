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
import com.lsmp.mp.customer.Address;

public class AddressDAO {
	
	public Set<Address> getAddresses(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Address> addresses = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE profileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String addressID= resultSet.getString("addressID");
				String street = resultSet.getString("street");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("zipCode");
				Address address = new Address();
				address.setAddressID(addressID);
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				address.setZipcode(zipcode);
				addresses.add(address);
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
		
		return addresses;
	}

	
public void insertAddresses(String id, Set<Address> addresses) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String addressID = "AD" + randomInt; */
			    
				Address currentAddress = addressIterator.next();
				
				String insertQuery = "INSERT INTO * address (addressID, profileID, street,city,state,zipcode)"
						+ "VALUES('"+currentAddress.getAddressID()+"','"+id+"','"+currentAddress.getStreet()+"','"+currentAddress.getCity()+"','"+currentAddress.getState()+"','"+currentAddress.getZipcode()+"')";
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

	public void insertAddress(String aid, String id, Address address) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String addressID = "AD" + randomInt; */
				
				String insertQuery = "INSERT INTO * address (addressID, profileID, street,city,state,zipcode)"
						+ "VALUES('"+aid+"','"+id+"','"+address.getStreet()+"','"+address.getCity()+"','"+address.getState()+"','"+address.getZipcode()+"')";
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
	
	public void deleteAddress(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM address WHERE profileID='"+id+"')";
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
	
	public void updateAddresses(String id, Set<Address> addresses) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				Address currentAddress = addressIterator.next();
				
				String updateQuery = "UPDATE address SET street='"+currentAddress.getStreet()+"', city='"+currentAddress.getCity()+"', state='"+currentAddress.getState()+"',zipcode='"+currentAddress.getZipcode()+"'  WHERE profileID='"+id+"')";
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
	
	public void updateAddress(String id, String addressID, Address address) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE address SET street='"+address.getStreet()+"', city='"+address.getCity()+"', state='"+address.getState()+"',zipcode='"+address.getZipcode()+"'  WHERE profileID='"+id+"' AND addressID='"+addressID+"')";
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
