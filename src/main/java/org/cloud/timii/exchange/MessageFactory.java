/**
 * 
 */
package org.cloud.timii.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
public class MessageFactory {
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Message m = new Message();
		m.setProductID("1234");
		m.setText("I would like to teach you GO (The programming language!!!");
		m.setUserID("Tim");
		String content = mapper.writeValueAsString(m);
		System.out.println(content);
	}
}
