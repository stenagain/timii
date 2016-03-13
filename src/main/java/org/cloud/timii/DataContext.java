/**
 * 
 */
package org.cloud.timii;

import java.math.BigDecimal;

import org.cloud.timii.catalog.Product;
import org.cloud.timii.catalog.Products;

/**
 * @author sten
 *
 */
public class DataContext {
	private static final DataContext INSTANCE = new DataContext();

	public static DataContext getInstance() {
		return INSTANCE;
	}

	private Products products = new Products();

	/**
	 * 
	 */
	public DataContext() {
		Product p = new Product();
		p.setName("Carpentry");
		p.setDescription("Making Cabinets");
		p.setPrice(new BigDecimal(150.00));

		products.getProducts().put(p.getID(), p);
		p = new Product();
		p.setName("Misha's Lawn Mowing");
		p.setDescription("Mow and trim Lawn");
		p.setPrice(new BigDecimal(30.00));
		products.getProducts().put(p.getID(), p);
	}

	/**
	 * @return the products
	 */
	public Products getProducts() {
		return products;
	}
}
