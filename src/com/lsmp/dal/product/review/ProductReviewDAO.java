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
	
	
	public ProductReview getBookReviewByProfileIDandProductID(String id, String pid) {
		String productID="";
		String profileID="";
		String review="";
		double rating=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview where bookProductID='" + id +"' AND profileID='" + pid +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			productID= resultSet.getString("bookProductID");
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
		productReview.setBookProductID(productID);
		productReview.setProfileID(profileID);
		productReview.setReview(review);
		productReview.setRating(rating);
		return productReview;	
	}
	
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
	}
	
	public Set<ProductReview> getAllBookReviews() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<ProductReview> productReviews = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productReview";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("bookProductID");
				String profileID = resultSet.getString("profileID");
				ProductReview productReview = getBookReviewByProfileIDandProductID(productID,profileID);
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
	
	public ProductReview addBookReview(String id, String pid, String prid, String review,double rating) {
			
			ProductReview ProductReview = new ProductReview();
			ProductReview.setProductReviewID(id);
			ProductReview.setBookProductID(pid);
			ProductReview.setProfileID(prid);
			ProductReview.setRating(rating);
			ProductReview.setReview(review);
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO productReview(productReviewID,bookProductID,profileID,review,rating) "
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
	}
	public void updateBookReview(String id, String pid, String review,double rating) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productReview SET review='"+review+"', rating='"+rating+"'  WHERE bookProductID='"+id+"' AND profileID='"+pid+"')";
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
	
	public void updateSmartphoneReview(String id, String pid, String review,double rating) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productReview SET review='"+review+"', rating='"+rating+"'  WHERE smartphoneProductID='"+id+"' AND profileID='"+pid+"')";
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
	
	public void deleteProductReview(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM productReview WHERE productReviewID='"+id+"')";
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
