/**
 * 
 */
package org.cloud.timii.product;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mig
 *
 */
public class ProductFactory {	
	public static Product create() {
		Product p = new Product();
		p.setName("We are great at java");
		p.setID(UUID.randomUUID().toString());
		p.setDescription("Teaching Youngins Java");
		p.setPrice(new BigDecimal(10));
		return p;
	}
	
	public static Product create(String name, String desc, double price) {
		Product p = new Product();
		p.setName(name);
		p.setID(UUID.randomUUID().toString());
		p.setDescription(desc);
		p.setPrice(new BigDecimal(price));
		return p;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Product p = ProductFactory.create();
		String content = mapper.writeValueAsString(p);
		System.out.println(content);
	}
}
