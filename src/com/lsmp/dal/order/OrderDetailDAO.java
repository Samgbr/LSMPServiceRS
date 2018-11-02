
package com.lsmp.dal.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.order.OrderDetail;

public class OrderDetailDAO {

	public OrderDetail getOrderDetail(String id) {
		String orderID="";
		String bookProductID="";
		String smartphoneProductID="";
		double orderedQuantity=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail where orderDetailID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			orderID= resultSet.getString("orderID");
			bookProductID = resultSet.getString("bookProductID");
			smartphoneProductID = resultSet.getString("smartphoneProductID");
			orderedQuantity = resultSet.getDouble("orderedQuantity");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderID(orderID);
		orderDetail.setBookProductID(bookProductID);
		orderDetail.setSmartphoneProductID(smartphoneProductID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;	
	}
	
	public OrderDetail getBookOrderDetail(String id) {
		String orderID="";
		String bookProductID="";
		double orderedQuantity=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail where orderDetailID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			orderID= resultSet.getString("orderID");
			bookProductID = resultSet.getString("bookProductID");
			orderedQuantity = resultSet.getDouble("orderedQuantity");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderID(orderID);
		orderDetail.setBookProductID(bookProductID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;	
	}
	
	public OrderDetail getSmartphoneOrderDetail(String id) {
		String orderID="";
		String smartphoneProductID="";
		double orderedQuantity=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail where orderDetailID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			orderID= resultSet.getString("orderID");
			smartphoneProductID = resultSet.getString("smartphoneProductID");
			orderedQuantity = resultSet.getDouble("orderedQuantity");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderID(orderID);
		orderDetail.setSmartphoneProductID(smartphoneProductID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;	
	}
	
	public Set<OrderDetail> getAllBookOrderDetails() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail WHERE bookProductID IS NOT NULL";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String orderDetailID = resultSet.getString("orderDetailID");
				OrderDetail orderDetail = getBookOrderDetail(orderDetailID);
				if(orderDetail != null) {
					orderDetails.add(orderDetail);
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
		
		return orderDetails;
		
	}
	
	public Set<OrderDetail> getAllSmartphoneOrderDetails() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail WHERE smartphoneProductID IS NOT NULL";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String orderDetailID = resultSet.getString("orderDetailID");
				OrderDetail orderDetail = getSmartphoneOrderDetail(orderDetailID);
				if(orderDetail != null) {
					orderDetails.add(orderDetail);
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
		
		return orderDetails;
		
	}

	/*
	public Set<OrderDetail> getAllOrderDetailsByProfileID(String pid) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail WHERE profileID='"+pid+"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String orderDetailID = resultSet.getString("orderDetailID");
				OrderDetail orderDetail = getOrderDetail(orderDetailID);
				if(orderDetail != null) {
					orderDetails.add(orderDetail);
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
		
		return orderDetails;
		
	}  */
	
	public Set<OrderDetail> getAllBookOrderDetailsByOrderID(String id) {
			
			Connection connection = DBConnect.getDatabaseConnection();
			Set<OrderDetail> orderDetails = new HashSet<>();
			
			try {
				Statement selectStatement = connection.createStatement();
				
				String selectQuery = "SELECT * from orderDetail WHERE orderID='"+id+"' AND bookProductID IS NOT NULL";
				ResultSet resultSet = selectStatement.executeQuery(selectQuery);
				
				while(resultSet.next()) {
					String orderDetailID = resultSet.getString("orderDetailID");
					OrderDetail orderDetail = getBookOrderDetail(orderDetailID);
					if(orderDetail != null) {
						orderDetails.add(orderDetail);
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
			
			return orderDetails;
			
		}
	
	public Set<OrderDetail> getAllSmartphoneOrderDetailsByOrderID(String id) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail WHERE orderID='"+id+"' AND smartphoneProductID IS NOT NULL";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String orderDetailID = resultSet.getString("orderDetailID");
				OrderDetail orderDetail = getSmartphoneOrderDetail(orderDetailID);
				if(orderDetail != null) {
					orderDetails.add(orderDetail);
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
		
		return orderDetails;
		
	}
	
	public OrderDetail addBookOrderDetail(String odid,String orderID, String productID, double orderedQuantity) {
			
			OrderDetail orderDetail = new OrderDetail();
			/*
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "OD" + randomInt; */
		    
		    orderDetail.setOrderDetailID(odid);
		    orderDetail.setOrderID(orderID);
		    orderDetail.setBookProductID(productID);
		    orderDetail.setOrderedQuantity(orderedQuantity);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,bookProductID,orderedQuantity) "
						+ "VALUES('"+odid+"','"+orderID+"','"+productID+"','"+orderedQuantity+"')";
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
			
			return orderDetail;
		}
	
	public OrderDetail addSmartphoneOrderDetail(String odid,String orderID, String productID, double orderedQuantity) {
		
		OrderDetail orderDetail = new OrderDetail();
		/*
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "OD" + randomInt; */
	    
	    orderDetail.setOrderDetailID(odid);
	    orderDetail.setOrderID(orderID);
	    orderDetail.setSmartphoneProductID(productID);
	    orderDetail.setOrderedQuantity(orderedQuantity);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,smartphoneProductID,orderedQuantity) "
					+ "VALUES('"+odid+"','"+orderID+"','"+productID+"','"+orderedQuantity+"')";
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
		
		return orderDetail;
	}

	public void updateBookOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE orderDetail SET orderID='"+orderID+"', bookProductID='"+productID+"', orderedQuantity='"+orderedQuantity+"'  WHERE orderDetailID='"+id+"'";
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
	
	public void updateSmartphoneOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE orderDetail SET orderID='"+orderID+"', smartphoneProductID='"+productID+"', orderedQuantity='"+orderedQuantity+"'  WHERE orderDetailID='"+id+"'";
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
	
	public void deleteOrderDetail(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM orderDetail WHERE orderDetailID='"+id+"'";
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

	public void addBookOrderDetails(Set<OrderDetail> orderDetails) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<OrderDetail> orderDetailsIterator = orderDetails.iterator();
			
			while(orderDetailsIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String orderDetailID = "OD" + randomInt;  */
				OrderDetail currentOrderDetail = orderDetailsIterator.next();
				
				String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,bookProductID,orderedQuantity) "
						+ "VALUES('"+currentOrderDetail.getOrderDetailID()+"','"+currentOrderDetail.getOrderID()+"','"+currentOrderDetail.getBookProductID()+"','"+currentOrderDetail.getOrderedQuantity()+"')";
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
	
	public void addSmartphoneOrderDetails(Set<OrderDetail> orderDetails) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<OrderDetail> orderDetailsIterator = orderDetails.iterator();
			
			while(orderDetailsIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String orderDetailID = "OD" + randomInt;  */
				OrderDetail currentOrderDetail = orderDetailsIterator.next();
				
				String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,smartphoneProductID,orderedQuantity) "
						+ "VALUES('"+currentOrderDetail.getOrderDetailID()+"','"+currentOrderDetail.getOrderID()+"','"+currentOrderDetail.getSmartphoneProductID()+"','"+currentOrderDetail.getOrderedQuantity()+"')";
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
}
