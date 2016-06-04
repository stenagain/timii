package org.cloud.timii.exchange;

import org.cloud.timii.Res;
/**
 * 
 * Product Service API
 * 
 * @author Mig
 *
 */
public interface CommodityService {

	public Res<Commodities> getProducts();
	 
	public Res<Commodities> getProducts(String descStr);

	public Res<Commodity> getProductByID(String id);

	public Res<Commodity> createProduct(Commodity product);

	public Res<Commodity> updateProduct(Commodity p);

	public Res<Commodity> deleteProduct(String id);

}