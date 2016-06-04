/**
 * 
 */
package org.cloud.timii.exchange;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mig
 *
 */
public class CommodityFactory {	
	public Commodity create() {
		Commodity p = new Commodity();
		p.setName("We are great at java");
		p.setID(UUID.randomUUID().toString());
		p.setDescription("Teaching Youngins Java");
		p.setPrice(new BigDecimal(10));
		return p;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		CommodityFactory factory = new CommodityFactory();
		Commodity p = factory.create();
		String content = mapper.writeValueAsString(p);
		System.out.println(content);
	}
}
