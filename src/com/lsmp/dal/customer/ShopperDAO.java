package com.lsmp.dal.customer;

import java.util.HashSet;
import java.util.Set;

import com.lsmp.dal.order.OrderDAO;
import com.lsmp.dal.product.review.ProductReviewDAO;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.product.review.ProductReview;

public class ShopperDAO extends CustomerDAO {
	
	private OrderDAO orderDAO;
	private ProductReviewDAO productReviewDAO;
	
	public ShopperDAO() {
		orderDAO = new OrderDAO();
		productReviewDAO = new ProductReviewDAO();
	}
	
	public Shopper getShopper(String id) {
		Set<Order> orders = new HashSet<>();
		Set<ProductReview> reviews = new HashSet<>();
					
		orders = orderDAO.getOrders(id);
		reviews  = productReviewDAO.getProductReviews(id);
		
		Shopper shopper = new Shopper();
		shopper.setOrders(orders);
		shopper.setReviews(reviews);
		return shopper;	
	
	}
	
	
}
