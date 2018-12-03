package com.lsmp.mp.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.order.Cancel;
import com.lsmp.mp.order.Complete;
import com.lsmp.mp.order.InProcess;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.review.ProductReviewManager;

public final class MarketPlaceServiceClient {

	public static void main(String[] args) {
		
		//Customer Manager 
		CustomerManager customerManager = new CustomerManager();
		
		List<Object> providers = new ArrayList<Object>();
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.addUntouchable(Response.class);
        providers.add(provider);
        
        /*****************************************************************************************
         * GET METHOD invoke
         *****************************************************************************************/
        System.out.println("GET METHOD .........................................................");
        WebClient getClient = WebClient.create("http://localhost:8082", providers);
        
        //Configuring the CXF logging interceptor for the outgoing message
        WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
      //Configuring the CXF logging interceptor for the incoming response
        WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
        
        // change application/xml  to get in xml format
        getClient = getClient.accept("application/json").type("application/json").path("/shopperservice/shopper/SH45897");
        
        //The following lines are to show how to log messages without the CXF interceptors
        String getRequestURI = getClient.getCurrentURI().toString();
        System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
        String getRequestHeaders = getClient.getHeaders().toString();
        System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
        
        //to see as raw XML/json
        String response = getClient.get(String.class);
        System.out.println("GET METHOD Response: ...." + response);
		
		//cManager(customerManager);
		
		//Product Manager
		ProductManager productManager = new ProductManager();
		
		//pManager(productManager);
		
		//Order Manager
		OrderManager orderManager = new OrderManager();
		
		//Order order = oManager(orderManager);
		
		//Order Status in process using state design pattern
		//orderProcessingAndComplete(order);
		
		//Partner Manager
		PartnerManager partnerManager = new PartnerManager();
		//parManager(partnerManager,customerManager);
		
		//Product Review Manager
		ProductReviewManager productReviewManager = new ProductReviewManager();
		//proRevManager(productReviewManager);
		
		System.exit(0);
	}

	private static void proRevManager(ProductReviewManager productReviewManager) {
		//Add book review
		productReviewManager.addProductReview("BO89743", "SH45897", "Great Product", 4.2);
		productReviewManager.addProductReview("BO45459", "SH45897", "Not recommend this book", 2.9);
		//update book review
		productReviewManager.updateProductReview("BO45459", "SH45897", "Not bad after all", 3.7);
		//Delete book review
		productReviewManager.deleteProductReview("PR65451");
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
		partnerManager.addPartnerProfile("diknas", "Nassir", "Raul", "Dickson", "dskf@gmail.com", "Wegh$$8i", "Level 3", "XYZS Co.", addresses, phones, bills);
		
	}

	private static void orderProcessingAndComplete(Order order) {
		//No Order yet
		order.noOrderYet();
		//Order fulfilled and in process
		order.setOrderStarted(true);
		order.updateOrderInProcess();
		//Order Complete
		order.updateOrderComplete();
		//Order Cancel
		order.updateOrderCancel();
	}

	private static Order oManager(OrderManager orderManager) {
		//Order and order detail creation
		OrderDetail orderDetail1 = orderManager.createOrderDetail("OD45617","OR88960", "BO45457", 2.0);
		OrderDetail orderDetail2 = orderManager.createOrderDetail("OD45610","OR88960" ,"BO89789", 2.0);
		Set<OrderDetail> details = new HashSet<>();
		details.add(orderDetail1);
		details.add(orderDetail2);
		Order order =orderManager.addOrder("SH45451", "01/11/2018", "AD78984",details);
		//Update order
		orderManager.updateOrderDetail("OD45610", "OR88960", "BO89789", 3.0);
		//Delete order
		orderManager.deleteOrderDetail("OD45617");
		orderManager.deleteOrderDetail("OD45610");
		return order;
	}

	private static void pManager(ProductManager productManager) {
		//Book Creation
		productManager.addBook("fdgknkln22", "Mcgraw hill", "Adam reta", "7th", "Ebook", "XXX", "suspense book", 12.99, 20.99, 0.125, "A Dart","PA95687");
		productManager.addBook("fdgfjln22", "Mcgraw hill", "Ptr reta", "5th", "paper", "YYY", "psychology book", 10.99, 15.99, 0.115, "The dark knight","");
		productManager.addBook("fdgfjln22", "Mcgraw hill", "Ptr reta", "5th", "CD", "YYY", "Dude book", 9.99, 12.99, 0.115, "The okay knight","");
		//Update book
		productManager.updateBook("BO89789", "fdgfjln22", "Mcgraw hill", "Ptr reta", "5th", "paper", "YYY", "psychology book", 17.99, 21.99, 0.17, "The dark knight","");
		//Delete book
		productManager.deleteBook("BO89999");
		//Create Product Inventory
		productManager.addProductQtyOnHand("IN98554","BO89743", 10.0);
		productManager.addProductQtyOnHand("IN98556","BO89789", 10.0);
		//Update Product Inventory
		productManager.updateProductQtyOnHand("BO89743", 20.0);
		//Delete Product Inventory
		//productManager.deleteBookQtyOnHand("BO89789");
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
		customerManager.addShopperProfile(shopper.getLoginID(), shopper.getFirstName(), shopper.getMiddleName(), shopper.getLastName(), shopper.getEmail()
					, shopper.getPassword(), shopper.getShopperType(), addresses, phones, bills);
		//Delete Customer
		//customerManager.deleteShopperProfile(shopper.getProfileID());
	}

}
