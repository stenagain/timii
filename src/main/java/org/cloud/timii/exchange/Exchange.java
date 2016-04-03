/**
 * 
 */
package org.cloud.timii.exchange;

import java.util.List;
import java.util.Map;

import org.cloud.timii.Res;

/**
 * @author sten
 *
 */
public interface Exchange {

	public Res<Map<String, List<Message>>> listOffers();

	public Res<Map<String, Message>> listRequests();

	public Res<Message> offerProduct(Message offer);

	public Res<Message> removeProduct(Message remove);

	public Res<Message> requestProduct(Message req);

	public Res<MessageResponse> acceptProductRequest(MessageResponse response);

	// public void acceptService(String productID);
}
