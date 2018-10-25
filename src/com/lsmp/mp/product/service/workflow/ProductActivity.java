package com.lsmp.mp.product.service.workflow;


import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.Product;
import com.lsmp.mp.product.service.representation.ProductRepresentation;

//This class is responsible for accessing the work flow of ProductDAO CRUD object

public class ProductActivity {
	
	public static ProductManager productManager=new ProductManager();
	
	public ProductRepresentation getProduct(String id) {
		
		Product product=productManager.getBook(id);
		
		ProductRepresentation productRepresentation=new ProductRepresentation();
		productRepresentation.setProductID(product.getProductID());
		productRepresentation.setProductName(product.getProductName());
		productRepresentation.setDescription(product.getDescription());
		productRepresentation.setPurchasePrice(product.getPurchasePrice());
		productRepresentation.setSellingPrice(product.getSellingPrice());
		productRepresentation.setProductName(product.getProductName());
		productRepresentation.setDiscount(product.getDiscount());
		
		return productRepresentation;
		
	}

}
