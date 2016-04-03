/**
 * 
 */
package org.cloud.timii;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.cloud.timii.exchange.ExchangeEndpoint;
import org.cloud.timii.product.ProductEndpoint;
import org.cloud.timii.review.ReviewEndpoint;

/**
 * @author sten
 *
 */
public class TestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

//		clazzes.add(ReviewEndpoint.class);
//		clazzes.add(ExchangeEndpoint.class);
//		clazzes.add(ProductEndpoint.class);
		return clazzes;
	}
	
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getSingletons()
	 */
	@Override
	public Set<Object> getSingletons() {
		final Set<Object> clazzes = new HashSet<Object>();
		clazzes.add(new ReviewEndpoint());
		clazzes.add(new ProductEndpoint());
		clazzes.add(ExchangeEndpoint.class);
		return clazzes;
	}

}