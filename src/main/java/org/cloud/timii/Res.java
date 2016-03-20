/**
 * 
 */
package org.cloud.timii;

/**
 * @author sten
 *
 */
public class Res<T> {
	public enum Type {
		BAD_REQUEST, CREATED, NOT_FOUND, OK;
	}

	private Type type;
	private String message;
	private T object;

	/**
 * 
 */
	public Res() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Res(Type type, String message, T object) {
		super();
		this.type = type;
		this.message = message;
		this.object = object;
	}



	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the object
	 */
	public T getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(T object) {
		this.object = object;
	}

}
