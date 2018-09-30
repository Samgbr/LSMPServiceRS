package com.lsmp.dal.partner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.partner.PartnerProduct;

public class PartnerProductDAO {

	public PartnerProduct getPartnerProductProfileBYProductID(String id) {
		String profileID="";
		
		Map<String,String> partnerProductMap = new HashMap<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from partnerproduct where productID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			profileID= resultSet.getString("profileID");
			partnerProductMap.put(id, profileID);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		PartnerProduct partnerProduct = new PartnerProduct();
		partnerProduct.setPartnerProduct(partnerProductMap);
		
		return partnerProduct;	
	}
	
	public Set<PartnerProduct> getAllPartnerProducts() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<PartnerProduct> partnerProducts = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from partnerproduct";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("productID");
				PartnerProduct partnerProduct = getPartnerProductProfileBYProductID(productID);
				if(partnerProduct != null) {
					partnerProducts.add(partnerProduct);
				}
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
		
		return partnerProducts;
		
	}
	
	public PartnerProduct addPartnerProduct(String id, String profileID) {
			
		Map<String,String> partnerProductMap = new HashMap<>();
			
			PartnerProduct partnerProduct = new PartnerProduct();
		    
			partnerProductMap.put(id, profileID);
			
			partnerProduct.setPartnerProduct(partnerProductMap);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO * productpartner (productID,profileID)"
						+ "VALUES('"+id+"','"+profileID+"')";
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
			
			return partnerProduct;
		}

	public void updatePartnerProduct(String id, String profileID) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE partnerproduct SET profileID='"+profileID+"'  WHERE productID='"+id+"')";
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
	
	public void deletePartnerProduct(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM partnerproduct WHERE productID='"+id+"')";
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
}
