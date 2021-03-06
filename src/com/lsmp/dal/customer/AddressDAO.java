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
import com.lsmp.mp.customer.Shopper;

public class AddressDAO {
	
	public Set<Address> getShopperAddresses(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Address> addresses = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE shopperProfileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String addressID= resultSet.getString("addressID");
				String shopperProfileID = resultSet.getString("shopperProfileID");
				String street = resultSet.getString("street");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("zipCode");
				Address address = new Address();
				address.setAddressID(addressID);
				address.setStreet(street);
				address.setCity(city);
				address.setState(state);
				address.setShopperProfileID(shopperProfileID);
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

	public Address getShopperAddress(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Address address = new Address();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE addressID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			String shopperProfileID= resultSet.getString("shopperProfileID");
			String street = resultSet.getString("street");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			String zipcode = resultSet.getString("zipCode");
			
			address.setAddressID(id);
			address.setShopperProfileID(shopperProfileID);
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setZipcode(zipcode);
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return address;
	}
	
	public Address getPartnerAddress(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Address address = new Address();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE addressID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			String partnerProfileID= resultSet.getString("partnerProfileID");
			String street = resultSet.getString("street");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			String zipcode = resultSet.getString("zipCode");
			
			address.setAddressID(id);
			address.setPartnerProfileID(partnerProfileID);
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setZipcode(zipcode);
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return address;
	}
	
	public Set<Address> getPartnerAddresses(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Address> addresses = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from address WHERE partnerProfileID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String addressID= resultSet.getString("addressID");
				String partnerProfileID = resultSet.getString("partnerProfileID");
				String street = resultSet.getString("street");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zipcode = resultSet.getString("zipCode");
				Address address = new Address();
				address.setAddressID(addressID);
				address.setStreet(street);
				address.setPartnerProfileID(partnerProfileID);
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
	
	public void insertShopperAddresses(String id, Set<Address> addresses) {
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				Iterator<Address> addressIterator = addresses.iterator();
				
				while(addressIterator.hasNext()) {
					
					Random randomGenerator = new Random();
				    int randomInt = randomGenerator.nextInt(10000);
				    String addressID = "AD" + randomInt; 
				    
					Address currentAddress = addressIterator.next();
					
					String insertQuery = "INSERT INTO address(addressID, shopperProfileID, street,city,state,zipcode) "
							+ "VALUES('"+addressID+"','"+id+"','"+currentAddress.getStreet()+"','"+currentAddress.getCity()+"','"+currentAddress.getState()+"','"+currentAddress.getZipcode()+"')";
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
	
	public void insertPartnerAddresses(String id, Set<Address> addresses) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String addressID = "AD" + randomInt; 
			    
				Address currentAddress = addressIterator.next();
				
				String insertQuery = "INSERT INTO address(addressID, partnerProfileID, street,city,state,zipcode) "
						+ "VALUES('"+addressID+"','"+id+"','"+currentAddress.getStreet()+"','"+currentAddress.getCity()+"','"+currentAddress.getState()+"','"+currentAddress.getZipcode()+"')";
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

	public Address insertShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		Address address = new Address();
		address.setAddressID(aid);
		address.setCity(city);
		address.setShopperProfileID(pid);
		address.setState(state);
		address.setStreet(street);
		address.setZipcode(zipcode);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String addressID = "AD" + randomInt; */
				
				String insertQuery = "INSERT INTO address(addressID, shopperProfileID, street,city,state,zipcode) "
						+ "VALUES('"+aid+"','"+pid+"','"+street+"','"+city+"','"+state+"','"+zipcode+"')";
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
		return address;		
	}
	
	public Address insertPartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		Address address = new Address();
		address.setAddressID(aid);
		address.setCity(city);
		address.setPartnerProfileID(pid);
		address.setState(state);
		address.setStreet(street);
		address.setZipcode(zipcode);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String addressID = "AD" + randomInt; */
				
				String insertQuery = "INSERT INTO address(addressID, partnerProfileID, street,city,state,zipcode) "
						+ "VALUES('"+aid+"','"+pid+"','"+street+"','"+city+"','"+state+"','"+zipcode+"')";
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
		return address;		
	}
	
	public void deleteShopperAddress(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM address WHERE shopperProfileID='"+id+"'";
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
	
	public void deletePartnerAddress(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM address WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperAddresses(String id, Set<Address> addresses) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				Address currentAddress = addressIterator.next();
				
				String updateQuery = "UPDATE address SET street='"+currentAddress.getStreet()+"', city='"+currentAddress.getCity()+"', state='"+currentAddress.getState()+"',zipcode='"+currentAddress.getZipcode()+"'  WHERE shopperProfileID='"+id+"'";
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
	
	public void updatePartnerAddresses(String id, Set<Address> addresses) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<Address> addressIterator = addresses.iterator();
			
			while(addressIterator.hasNext()) {
				Address currentAddress = addressIterator.next();
				
				String updateQuery = "UPDATE address SET street='"+currentAddress.getStreet()+"', city='"+currentAddress.getCity()+"', state='"+currentAddress.getState()+"',zipcode='"+currentAddress.getZipcode()+"'  WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE address SET street='"+street+"',shopperProfileID='"+pid+"', city='"+city+"', state='"+state+"',zipcode='"+zipcode+"'  WHERE addressID='"+aid+"'";
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
	
	public void updatePartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
				
			String updateQuery = "UPDATE address SET street='"+street+"',partnerProfileID='"+pid+"', city='"+city+"', state='"+state+"',zipcode='"+zipcode+"'  WHERE addressID='"+aid+"'";
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
