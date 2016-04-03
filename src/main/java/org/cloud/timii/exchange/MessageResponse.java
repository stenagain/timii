/**
 * 
 */
package org.cloud.timii.exchange;

/**
 * @author sten
 *
 */
public class MessageResponse extends Message{
	public enum Status {
		ACCEPT, REJECT;
	}

	private Status status = Status.ACCEPT;

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}
