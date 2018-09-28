package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.customer.Address;

public class AddressDAO {
	
	public Set<Address> getAddresses(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Address> addresses = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE customerID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String street = resultSet.getString("street");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("zipCode");
				Address address = new Address();
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
				Address currentAddress = addressIterator.next();
				
				String insertQuery = "INSERT INTO * address (customerID, street,city,state,zipcode)"
						+ "VALUES('"+id+"','"+currentAddress.getStreet()+"','"+currentAddress.getCity()+"','"+currentAddress.getState()+"','"+currentAddress.getZipcode()+"')";
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
	
	public void deleteAddress(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM address WHERE customerID='"+id+"')";
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
	
	public void updateAddress(String id, Set<Address> addresses) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				Address currentAddress = addressIterator.next();
				
				String updateQuery = "UPDATE address SET street='"+currentAddress.getStreet()+"', city='"+currentAddress.getCity()+"', state='"+currentAddress.getState()+"',zipcode='"+currentAddress.getZipcode()+"'  WHERE customerID='"+id+"')";
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
