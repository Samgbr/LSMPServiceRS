package com.lsmp.mp.client;

import java.util.HashSet;
import java.util.Set;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.order.Complete;
import com.lsmp.mp.order.InProcess;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.review.ProductReviewManager;

public class MarketPlaceServiceClient {

	public static void main(String[] args) {
		// TODO run the application modules
		
		//Customer Manager 
		CustomerManager customerManager = new CustomerManager();
		
		cManager(customerManager);
		
		//Product Manager
		ProductManager productManager = new ProductManager();
		
		pManager(productManager);
		
		//Order Manager
		OrderManager orderManager = new OrderManager();
		
		Order order = oManager(orderManager);
		
		//Order Status in process using state design pattern
		orderProcessingAndComplete(order);
		
		//Partner Manager
		PartnerManager partnerManager = new PartnerManager();
		parManager(partnerManager,customerManager);
		
		//Product Review Manager
		ProductReviewManager productReviewManager = new ProductReviewManager();
		proRevManager(productReviewManager);
	}

	private static void proRevManager(ProductReviewManager productReviewManager) {
		productReviewManager.addProductReview("BO89743", "SH45897", "Great Product", 4.2);
	}

	private static void parManager(PartnerManager partnerManager, CustomerManager customerManager) {
		//Create Addresses
		Address address1 = customerManager.createAddress("AD45699", "Wilson St.", "Chicago", "IL", "60630");
		Address address2 = customerManager.createAddress("AD45648", "Clark St.", "Isle", "IL", "60630");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		//Create phone
		Phone phone1 = customerManager.createPhone("PH77765", "Home", "312-985-7452");
		Phone phone2 = customerManager.createPhone("PH83367", "Office", "312-102-7952");
		Set<Phone> phones = new HashSet<>();
		phones.add(phone1);
		phones.add(phone2);
		//Create bill
		Bill bill1 = customerManager.createBill("BI89266", "4564789578544523", 789, 9, 22);
		Bill bill2 = customerManager.createBill("BI09667", "4546789577914523", 426, 12, 21);
		Set<Bill> bills = new HashSet<>();
		bills.add(bill1);
		bills.add(bill2);
		
		//Create a Partner
		partnerManager.addPartnerProfile("PA95687","diknas", "Nassir", "Raul", "Dickson", "dskf@gmail.com", "Wegh$$8i", "Level 3", "XYZS Co.", addresses, phones, bills);
		//Add partner product
		partnerManager.addPartnerProduct("PP61923", "BO89789", "PA95687");
	}

	private static void orderProcessingAndComplete(Order order) {
		InProcess processing = new InProcess();
		order.setStatus(processing);
		//Package Picked
		processing.setPicked(true);
		//Package packed
		processing.setPacked(true);
		//Package delivered to pick up location
		processing.setDeliverdToPickupLocation(true);
		//Order Completed
		Complete complete = new Complete();
		//Pickup location
		complete.setPickupLocation("Belmont Store");
		//Package delivered
		complete.setDelivered(true);
		order.setStatus(complete);
	}

	private static Order oManager(OrderManager orderManager) {
		//Order and order detail creation
		OrderDetail orderDetail1 = orderManager.addOrderDetail("OD45698", "OR78954", "BO89743", 2.0);
		OrderDetail orderDetail2 = orderManager.addOrderDetail("OD45698", "OR78954", "BO89789", 3.0);
		Set<OrderDetail> details = new HashSet<>();
		details.add(orderDetail1);
		details.add(orderDetail2);
		Order order =orderManager.addOrder("OR78954", "SH45897", "10/10/2018", "AD45688",details);
		return order;
	}

	private static void pManager(ProductManager productManager) {
		//Book Creation
		productManager.addBook("BO89743", "fdgknkln22", "Mcgraw hill", "Adam reta", "7th", "Ebook", "XXX", "suspense book", 12.99, 20.99, 0.125, "A Dart");
		productManager.addBook("BO89789", "fdgfjln22", "Mcgraw hill", "Ptr reta", "5th", "paper", "YYY", "psychology book", 10.99, 15.99, 0.115, "The dark knight");
		//Create Product Inventory
		productManager.addProductQtyOnHand("IN98554","BO89743", 10.0);
		productManager.addProductQtyOnHand("IN98556","BO89789", 10.0);
	}

	private static void cManager(CustomerManager customerManager) {
		//Create a shopper
		Shopper shopper = customerManager.createShopper("SH45897", "gabriel", "Pascal", "Peter", "Dawit", "hg@gmail.com", "!2Soprw", "prime");
		//Create Addresses
		Address address1 = customerManager.createAddress("AD45687", "Addison St.", "Chicago", "IL", "60640");
		Address address2 = customerManager.createAddress("AD45688", "Clark St.", "Wheathon", "IL", "60640");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		//Create phone
		Phone phone1 = customerManager.createPhone("PH89765", "Home", "312-986-7552");
		Phone phone2 = customerManager.createPhone("PH89767", "Office", "312-002-7552");
		Set<Phone> phones = new HashSet<>();
		phones.add(phone1);
		phones.add(phone2);
		//Create bill
		Bill bill1 = customerManager.createBill("BI89666", "4564789578954523", 123, 10, 21);
		Bill bill2 = customerManager.createBill("BI89667", "4564789588914523", 456, 12, 20);
		Set<Bill> bills = new HashSet<>();
		bills.add(bill1);
		bills.add(bill2);
		//Create Shopper Profile
		customerManager.addShopperProfile(shopper.getProfileID(), shopper.getLoginID(), shopper.getFirstName(), shopper.getMiddleName(), shopper.getLastName(), shopper.getEmail()
					, shopper.getPassword(), shopper.getShopperType(), addresses, phones, bills);
	}

}
