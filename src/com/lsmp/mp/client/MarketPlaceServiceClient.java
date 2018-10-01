package com.lsmp.mp.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.product.Book;
import com.lsmp.mp.product.Inventory;
import com.lsmp.mp.product.ProductManager;

public class MarketPlaceServiceClient {

	public static void main(String[] args) {
		// TODO run the application modules
		
		//Create a shopper
		Shopper shopper = new Shopper();
		CustomerManager customerManager = new CustomerManager();
		shopper.setProfileID("SH45897");
		shopper.setLoginID("gabriel");
		shopper.setFirstName("Pascal");
		shopper.setMiddleName("Peter");
		shopper.setLastName("Dawit");
		shopper.setEmail("hg@gmail.com");
		shopper.setPassword("!2Soprw");
		shopper.setShopperType("prime");
		//Create Addresses
		Address address1 = new Address();
		address1.setAddressID("AD45687");
		address1.setCity("Chicago");
		address1.setState("IL");
		address1.setStreet("Addison St.");
		address1.setZipcode("60640");
		Address address2 = new Address();
		address2.setAddressID("AD45688");
		address2.setCity("Wheathon");
		address2.setState("IL");
		address2.setStreet("Clark St.");
		address2.setZipcode("60640");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		//Create phone
		Phone phone1 = new Phone();
		phone1.setPhoneID("PH89765");
		phone1.setType("Home");
		phone1.setPhoneNumber("312-986-7552");
		Phone phone2 = new Phone();
		phone2.setPhoneID("PH89767");
		phone2.setType("Office");
		phone2.setPhoneNumber("312-002-7552");
		Set<Phone> phones = new HashSet<>();
		phones.add(phone1);
		phones.add(phone2);
		Bill bill1=new Bill();
		bill1.setBillID("BI89666");
		bill1.setCreditCardNumber("4564789578954523 ");
		bill1.setCvv(123);
		bill1.setExpiryMonth(10);
		bill1.setExpiryYear(21);
		Bill bill2=new Bill();
		bill2.setBillID("BI89667");
		bill2.setCreditCardNumber("4564789588914523 ");
		bill2.setCvv(456);
		bill2.setExpiryMonth(12);
		bill2.setExpiryYear(20);
		Set<Bill> bills = new HashSet<>();
		bills.add(bill1);
		bills.add(bill2);
		customerManager.addShopperProfile(shopper.getProfileID(), shopper.getLoginID(), shopper.getFirstName(), shopper.getMiddleName(), shopper.getLastName(), shopper.getEmail()
					, shopper.getPassword(), shopper.getShopperType(), addresses, phones, bills);
		//Book Creation
		Book book1 = new Book();
		book1.setProductID("BO89743");
		book1.setIsbn("fdgknkln22");
		book1.setPublisher("Mcgraw hill");
		book1.setAuthor("Adam reta");
		book1.setEdition("7th");
		book1.setBookType("Ebook");
		book1.setProductName("XXX");
		book1.setDescription("suspense book");
		book1.setPurchasePrice(12.99);
		book1.setSellingPrice(20.99);
		book1.setDiscount(0.125);
		book1.setTitle("A Dart");
		Book book2 = new Book();
		book2.setProductID("BO89789");
		book2.setIsbn("fdgfjln22");
		book2.setPublisher("Mcgraw hill");
		book2.setAuthor("Ptr reta");
		book2.setEdition("5th");
		book2.setBookType("paper");
		book2.setProductName("XXX");
		book2.setDescription("sse book");
		book2.setPurchasePrice(10.99);
		book2.setSellingPrice(15.99);
		book2.setDiscount(0.115);
		book2.setTitle("A Brad");
		//Inventory
		ProductManager pManager = new ProductManager();
		pManager.addProductQtyOnHand("IN98554","BO89743", 10.0);
		pManager.addProductQtyOnHand("IN98556","BO89789", 10.0);
		pManager.addBook(book1.getProductID(), book1.getProductName(), book1.getDescription(), book1.getPurchasePrice(), book1.getSellingPrice()
					, book1.getDiscount(), book1.getTitle(), book1.getIsbn(),book1.getPublisher(), book1.getAuthor(), book1.getEdition(), book1.getBookType());
		pManager.addBook(book2.getProductID(), book2.getProductName(), book2.getDescription(), book2.getPurchasePrice(), book2.getSellingPrice()
				, book2.getDiscount(), book2.getTitle(), book2.getIsbn(),book2.getPublisher(), book2.getAuthor(), book2.getEdition(), book2.getBookType());
		//Order Creation
		Order order = new Order();
		order.setOrderID("OR78954");
		order.setProfileID("SH45897");
		order.setOrderDate("10/10/2018");
		order.setShipAddressID("AD45688");
		//Order Detail
		OrderDetail orderDetail1 = new OrderDetail();
		orderDetail1.setOrderDetailID("OD45698");
		orderDetail1.setOrderID("OR78954");
		orderDetail1.setProductID("BO89743");
		orderDetail1.setOrderedQuantity(2.0);
		OrderDetail orderDetail2 = new OrderDetail();
		orderDetail2.setOrderDetailID("OD45698");
		orderDetail2.setOrderID("OR78954");
		orderDetail2.setProductID("BO89789");
		orderDetail2.setOrderedQuantity(3.0);
		Set<OrderDetail> details = new HashSet<>();
		details.add(orderDetail1);
		details.add(orderDetail2);
		OrderManager orderManager = new OrderManager();
		orderManager.addOrder(order.getOrderID(), order.getProfileID(), order.getOrderDate(), order.getShipAddressID(),details);
	}

}
