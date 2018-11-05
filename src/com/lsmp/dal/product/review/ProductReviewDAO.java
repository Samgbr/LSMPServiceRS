package com.lsmp.dal.product.review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.product.review.ProductReview;

public class ProductReviewDAO {
	
	
	public ProductReview getProductReviewByProfileIDandProductID(String id, String pid) {
		String productID="";
		String profileID="";
		String review="";
		double rating=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview where productID='" + id +"' AND profileID='" + pid +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			productID= resultSet.getString("productID");
			profileID = resultSet.getString("profileID");
			review = resultSet.getString("review");
			rating = resultSet.getDouble("rating");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		ProductReview productReview = new ProductReview();
		productReview.setProductID(productID);
		productReview.setProfileID(profileID);
		productReview.setReview(review);
		productReview.setRating(rating);
		return productReview;	
	}
	/*
	public ProductReview getSmartphoneReviewByProfileIDandProductID(String id, String pid) {
		String smartphoneProductID="";
		String profileID="";
		String review="";
		double rating=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview where smartphoneProductID='" + id +"' AND profileID='" + pid +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			smartphoneProductID= resultSet.getString("smartphoneProductID");
			profileID = resultSet.getString("profileID");
			review = resultSet.getString("review");
			rating = resultSet.getDouble("rating");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		ProductReview productReview = new ProductReview();
		productReview.setSmartphoneProductID(smartphoneProductID);
		productReview.setProfileID(profileID);
		productReview.setReview(review);
		productReview.setRating(rating);
		return productReview;	
	}  */
	
	public Set<ProductReview> getAllProductReviews() {

		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<ProductReview> productReviews = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("productID");
				String profileID = resultSet.getString("profileID");
				ProductReview productReview = getProductReviewByProfileIDandProductID(productID,profileID);
				if(productReview != null) {
					productReviews.add(productReview);
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
		
		return productReviews;
		
	}
	/*
	public Set<ProductReview> getAllSmartPhoneReviews() {

		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<ProductReview> productReviews = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview WHERE smartphoneProductID IS NOT NULL";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("smartphoneProductID");
				String profileID = resultSet.getString("profileID");
				ProductReview productReview = getSmartphoneReviewByProfileIDandProductID(productID,profileID);
				if(productReview != null) {
					productReviews.add(productReview);
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
		
		return productReviews;
		
	}  */

	
	public ProductReview addProductReview(String id, String pid, String prid, String review,double rating) {
			
			ProductReview ProductReview = new ProductReview();
			ProductReview.setProductReviewID(id);
			ProductReview.setProductID(pid);
			ProductReview.setProfileID(prid);
			ProductReview.setRating(rating);
			ProductReview.setReview(review);
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO productReview(productReviewID,productID,profileID,review,rating) "
						+ "VALUES('"+id+"','"+pid+"','"+prid+"','"+review+"','"+rating+"')";
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
			
			return ProductReview;
		}
	/*
	public ProductReview addSmartphoneReview(String id, String pid, String prid, String review,double rating) {
		
		ProductReview ProductReview = new ProductReview();
		ProductReview.setProductReviewID(id);
		ProductReview.setSmartphoneProductID(pid);
		ProductReview.setProfileID(prid);
		ProductReview.setRating(rating);
		ProductReview.setReview(review);
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO productReview(productReviewID,smartphoneProductID,profileID,review,rating) "
					+ "VALUES('"+id+"','"+pid+"','"+prid+"','"+review+"','"+rating+"')";
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
		
		return ProductReview;
	}  */
	
	public void updateProductReview(String id, String pid, String review,double rating) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productReview SET review='"+review+"', rating='"+rating+"'  WHERE productID='"+id+"' AND profileID='"+pid+"'";
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
	/*
	public void updateSmartphoneReview(String id, String pid, String review,double rating) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productReview SET review='"+review+"', rating='"+rating+"'  WHERE smartphoneProductID='"+id+"' AND profileID='"+pid+"'";
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
	}  */
	
	public void deleteProductReview(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM productReview WHERE productReviewID='"+id+"'";
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