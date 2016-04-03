/**
 * 
 */
package org.cloud.timii.exchange;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.cloud.timii.Res;

/**
 * @author sten
 *
 */
public class ExchangeService implements Exchange {

	private Map<String, List<Message>> offerMap = new Hashtable<String, List<Message>>();
	private Map<String, Message> requestMap = new Hashtable<String, Message>();
	private Map<String, MessageResponse> responseMap = new Hashtable<String, MessageResponse>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cloud.timii.exchange.Exchange#listProducts()
	 */
	public Res<Map<String, List<Message>>> listOffers() {
		return new Res<Map<String, List<Message>>>(Res.Type.OK, "product list", offerMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cloud.timii.exchange.Exchange#listOffers()
	 */
	public Res<Map<String, Message>> listRequests() {
		return new Res<Map<String, Message>>(Res.Type.OK, "request list", requestMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.exchange.Exchange#offerProduct(org.cloud.timii.exchange.
	 * Message)
	 */
	public Res<Message> offerProduct(Message offer) {
		if (offerMap.containsKey(offer.productID)) {
			offerMap.get(offer.productID).add(offer);
		} else {
			List<Message> list = new Vector<Message>();
			list.add(offer);
			offerMap.put(offer.productID, list);
		}
		return new Res<Message>(Res.Type.CREATED, "offer placed", offer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.exchange.Exchange#removeProduct(org.cloud.timii.exchange.
	 * Message)
	 */
	public Res<Message> removeProduct(Message remove) {
		if (offerMap.containsKey(remove.productID)) {
			List<Message> list = offerMap.get(remove.productID);
			for (Iterator<Message> iterator = list.iterator(); iterator.hasNext();) {
				if (iterator.next().productID == remove.productID) {
					iterator.remove();
					return new Res<Message>(Res.Type.DELETED, "offer removed", remove);
				}
			}
		}
		return new Res<Message>(Res.Type.NOT_FOUND, "offer does not exist", remove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.exchange.Exchange#requestProduct(org.cloud.timii.exchange
	 * .Message)
	 */
	public Res<Message> requestProduct(Message req) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.exchange.Exchange#acceptProductRequest(org.cloud.timii.
	 * exchange.MessageResponse)
	 */
	public Res<MessageResponse> acceptProductRequest(MessageResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
