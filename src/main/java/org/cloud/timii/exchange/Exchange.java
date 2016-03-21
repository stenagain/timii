/**
 * 
 */
package org.cloud.timii.exchange;

import org.cloud.timii.ServiceRequest;
import org.cloud.timii.product.Product;

/**
 * @author sten
 *
 */
public interface Exchange {
	
	public void offer(Product product);
	public void request(ServiceRequest req);
	public void acceptRequest(String requestID);
	public void acceptService(String productID);
}
