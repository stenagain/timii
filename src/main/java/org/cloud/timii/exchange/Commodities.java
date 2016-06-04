/**
 * 
 */
package org.cloud.timii.exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sten
 *
 */
public class Commodities {
	private List<Commodity> products = new ArrayList<Commodity>();

	/**
	 * @return the products
	 */
	public List<Commodity> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Commodity> products) {
		this.products = products;
	}
	
}
