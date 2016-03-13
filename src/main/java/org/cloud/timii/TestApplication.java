/**
 * 
 */
package org.cloud.timii;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author sten
 *
 */
public class TestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

		clazzes.add(ExchangeEndpoint.class);
		clazzes.add(ProductEndpoint.class);
		return clazzes;
	}

}