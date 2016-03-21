package org.cloud.timii.product;

import org.cloud.timii.Res;
/**
 * 
 * Product Service API
 * 
 * @author Mig
 *
 */
public interface ProductService {

	public Res<Products> getProducts();
	 
	public Res<Products> getProducts(String descStr);

	public Res<Product> getProductByID(String id);

	public Res<Product> createProduct(Product product);

	public Res<Product> updateProduct(Product p);

	public Res<Product> deleteProduct(String id);

}