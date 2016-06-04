package org.cloud.timii.exchange;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.cloud.timii.Res;
import org.cloud.timii.review.Review;

/**
 * Default Product Service API Implementation
 * 
 * @author Mig
 *
 */
public class DefaultCommodityService implements CommodityService {
	private Map<String, Commodity> productsMap = new HashMap<String, Commodity>();
	private static final Logger LOG = Logger.getLogger(DefaultCommodityService.class.getName());

	/**
	 * Returns all available products
	 * 
	 * @return products
	 */
	public Res<Commodities> getProducts() {
		Commodities prods = new Commodities();
		prods.getProducts().addAll(productsMap.values());
		return new Res<Commodities>(Res.Type.OK, "Found prods", prods);
	}

	/**
	 * Get products with particular string in description
	 * @param descStr
	 *            - description
	 * @return List of products that match the description
	 */
	public Res<Commodities> getProducts(String descStr) {
		// check for null
		if (descStr == null) {
			return new Res<Commodities>(Res.Type.NOT_FOUND, "Product not found", null);
		}

		//
		// find all products that contain description
		//
		Commodities prods = new Commodities();
		for (Commodity p : productsMap.values()) {
			if (p.getDescription().contains(descStr)) {
				prods.getProducts().add(p);
			}
		}
		if (prods.getProducts().size() > 0) {
			return new Res<Commodities>(Res.Type.OK, "Products found", prods);
		}

		// no prods were found
		return new Res<Commodities>(Res.Type.NOT_FOUND, "Product not found", prods);
	}

	/**
	 * Get particular product by id
	 * @param id
	 * @return Product that matches passed id parameter
	 */
	public Res<Commodity> getProductByID(String id) {
		// check for null
		if (id == null) {
			return new Res<Commodity>(Res.Type.NOT_FOUND, "Product not found by id", null);
		}

		for (Commodity p : productsMap.values()) {
			if (p.getID().equals(id)) {
				return new Res<Commodity>(Res.Type.OK, "Product found", p);
			}
		}
		// no prods were found
		return new Res<Commodity>(Res.Type.NOT_FOUND, "Product not found", null);
	}

	
	/**
	 * creation of the Product
	 * 
	 * @param Commodity
	 *            - product to be added to datastore
	 */
	public Res<Commodity> createProduct(Commodity p) {

		LOG.info("Product created!" + p);
		if (isValid(p)) {			
			productsMap.put(p.getID(), p);
			System.out.println("map size is " + productsMap.size());			
			return new Res<Commodity>(Res.Type.CREATED, "Product created with id " + p.getID(), p);
		}
		return new Res<Commodity>(Res.Type.BAD_REQUEST, "invalid id", null);
	}


	/**
	 * Update a product
	 */
	public Res<Commodity> updateProduct(Commodity p) {
		if (isValid(p)) {
			if (productsMap.containsKey(p.getID())) {
				productsMap.put(p.getID(), p);
				return new Res<Commodity>(Res.Type.OK, "Product updated with id " + p.getID(), p);
			}
		}
		return new Res<Commodity>(Res.Type.BAD_REQUEST, "invalid id", null);
	}

	/**
	 * Delete a product
	 */
	public Res<Commodity> deleteProduct(String id) {
		if (id != null){
			if (productsMap.containsKey(id)) {
			
				Commodity p = productsMap.remove(id);

				return new Res<Commodity>(Res.Type.OK, "Product deleted with id " + id, p);
			}
		}
		return new Res<Commodity>(Res.Type.BAD_REQUEST, "invalid product id", null);
	}
	
	
	/**
	 * Determine whether product is valid
	 * 
	 * @param p
	 *            - product to be added
	 * @return - true if fields exists, null otherwise
	 */
	private boolean isValid(Commodity p) {
		if (null == p || null == p.getID() || null == p.getName() || null == p.getDescription()) {
			return false;
		}
		return true;
	}

}
