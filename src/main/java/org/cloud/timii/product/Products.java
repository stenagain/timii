/**
 * 
 */
package org.cloud.timii.product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sten
 *
 */
public class Products {
	private List<Product> products = new ArrayList<Product>();

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
