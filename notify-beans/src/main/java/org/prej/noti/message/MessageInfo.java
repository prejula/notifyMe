/**
 * 
 */
package org.prej.noti.message;

import java.io.Serializable;
import java.util.List;

import org.prej.noti.receiver.Receiver;


/**
 * @author ppp
 *
 */
public class MessageInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7460498849153613255L;

	private String msgId;
	
	private String message;
	
	private String type;
	
	private String sender;
	
	private List<Receiver> receiver;

	
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public List<Receiver> getReceiver() {
		return receiver;
	}

	public void setReceiver(List<Receiver> receiver) {
		this.receiver = receiver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
 