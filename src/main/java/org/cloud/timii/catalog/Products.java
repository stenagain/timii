/**
 * 
 */
package org.cloud.timii.catalog;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sten
 *
 */
public class Products {
	private Map<String, Product> products = new HashMap<String, Product>();

	/**
	 * @return the products
	 */
	public Map<String, Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
	
}
