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
	
	public Phone getShopperPhone(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Phone phone = new Phone();
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE phoneID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			String phoneID= resultSet.getString("phoneID");
			String type = resultSet.getString("type");
			String phoneNumber = resultSet.getString("phoneNumber");
			String shopperProfileID = resultSet.getString("shopperProfileID");
			
			phone.setPhoneID(phoneID);
			phone.setType(type);
			phone.setPhoneNumber(phoneNumber);
			phone.setShopperProfileID(shopperProfileID);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return phone;
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
	
	public Phone getPartnerPhone(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Phone phone = new Phone();
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from phone WHERE phoneID='"+id+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			String phoneID= resultSet.getString("phoneID");
			String type = resultSet.getString("type");
			String phoneNumber = resultSet.getString("phoneNumber");
			String partnerProfileID = resultSet.getString("partnerProfileID");
			
			phone.setPhoneID(phoneID);
			phone.setType(type);
			phone.setPhoneNumber(phoneNumber);
			phone.setPartnerProfileID(partnerProfileID);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return phone;
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
	
	public Phone insertShopperPhone(String pid, String id, String type, String phoneNumber) {
		Phone phone = new Phone();
		phone.setPhoneID(pid);
		phone.setShopperProfileID(id);
		phone.setType(type);
		phone.setPhoneNumber(phoneNumber);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt; */
				
				String insertQuery = "INSERT INTO phone(phoneID, shopperProfileID, type,phoneNumber) "
						+ "VALUES('"+pid+"','"+id+"','"+type+"','"+phoneNumber+"')";
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
		return phone;
	}
	
	public Phone insertPartnerPhone(String pid, String id, String type, String phoneNumber) {
		
		Phone phone = new Phone();
		phone.setPhoneID(pid);
		phone.setPartnerProfileID(id);
		phone.setType(type);
		phone.setPhoneNumber(phoneNumber);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String phoneID = "PH" + randomInt; */
				
				String insertQuery = "INSERT INTO phone(phoneID, partnerProfileID, type,phoneNumber) "
						+ "VALUES('"+pid+"','"+id+"','"+type+"','"+phoneNumber+"')";
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
		return phone;		
	}


	public void deleteShopperPhone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM phone WHERE phoneID='"+id+"'";
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
			
			String deleteQuery = "DELETE FROM phone WHERE phoneID='"+id+"'";
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
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', phoneNumber='"+currentPhone.getPhoneNumber()+"'  WHERE shopperProfileID='"+id+"'";
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
				
				String updateQuery = "UPDATE phone SET type='"+currentPhone.getType()+"', phoneNumber='"+currentPhone.getPhoneNumber()+"'  WHERE partnerProfileID='"+id+"'";
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
	
	public void updateShopperPhone(String pid, String id, String type, String phoneNumber) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE phone SET type='"+type+"', phoneNumber='"+phoneNumber+"', shopperProfileID='"+id+"'  WHERE phoneID='"+pid+"'";
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
	
	public void updatePartnerPhone(String pid, String id, String type, String phoneNumber) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE phone SET type='"+type+"', phoneNumber='"+phoneNumber+"', partnerProfileID='"+id+"'  WHERE phoneID='"+pid+"'";
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
