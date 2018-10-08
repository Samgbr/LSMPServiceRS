package com.lsmp.dal.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.product.Book;

public class BookDAO {
	
	//get, update, insert and delete goes here
	public Book getBook(String id) {
		String productName="";
		String description="";
		double purchasePrice=0.0;
		double sellingPrice=0.0;
		double discount=0.0;
		String title="";
		String isbn = "";
		String publisher = "";
		String author = "";
		String edition = "";
		String bookType="";
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from book where productID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			productName= resultSet.getString("productName");
			description = resultSet.getString("description");
			purchasePrice = resultSet.getDouble("purchasePrice");
			sellingPrice = resultSet.getDouble("sellingPrice");
			discount = resultSet.getDouble("discount");
			title = resultSet.getString("title");
			isbn = resultSet.getString("isbn");
			publisher = resultSet.getString("publisher");
			author = resultSet.getString("author");
			edition = resultSet.getString("edition");
			bookType = resultSet.getString("bookType");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Book book = new Book();
		book.setProductName(productName);
		book.setDescription(description);
		book.setPurchasePrice(purchasePrice);
		book.setSellingPrice(sellingPrice);
		book.setDiscount(discount);
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setPublisher(publisher);
		book.setAuthor(author);
		book.setEdition(edition);
		book.setBookType(bookType);
		return book;	
	}
	
	public Set<Book> getAllBooks() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Book> books = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from book";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("productID");
				Book book = getBook(productID);
				if(book != null) {
					books.add(book);
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
		
		return books;
		
	}
	
	public Book addBook(String bid,String productName, String description, double purchasePrice, double sellingPrice, 
				double discount, String title, String isbn, String publisher, String author, String edition, String bookType) {
			
			Book book = new Book();
			/*
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "BK" + randomInt; */
		    
			book.setProductID(bid);
			book.setProductName(productName);
			book.setDescription(description);
			book.setPurchasePrice(purchasePrice);
			book.setSellingPrice(sellingPrice);
			book.setDiscount(discount);
			book.setTitle(title);
			book.setIsbn(isbn);
			book.setPublisher(publisher);
			book.setAuthor(author);
			book.setEdition(edition);
			book.setBookType(bookType);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO book(productID,isbn,publisher,author,edition,bookType,productName,description,purchasePrice,sellingPrice,discount,title) "
						+ "VALUES('"+bid+"','"+isbn+"','"+publisher+"','"+author+"','"+edition+"','"+bookType+"','"+productName+"','"+description+"','"+purchasePrice+"','"+sellingPrice+"','"+discount+"','"+title+"')";
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
			
			return book;
		}

	public void updateBook(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String title, String isbn, String publisher, String author, String edition, String bookType) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE book SET productName='"+productName+"', description='"+description+"', purchasePrice='"+purchasePrice+"',sellingPrice='"+sellingPrice+"',discount='"+discount+"',title='"+title+"',isbn='"+isbn+"',publisher='"+publisher+"',author='"+author+"',edition='"+edition+"',bookType='"+bookType+"'  WHERE productID='"+id+"'";
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
	
	public void deleteBook(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM book WHERE productID='"+id+"'";
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
