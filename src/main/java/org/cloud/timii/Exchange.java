/**
 * 
 */
package org.cloud.timii;

import org.cloud.timii.model.Product;

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
