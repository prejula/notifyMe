/**
 * 
 */
package org.prej.noti.sender.sms;

import org.prej.noti.Server;
import org.prej.noti.message.MessageInfo;
import org.prej.noti.sender.Sender;

/**
 * @author ppp
 *
 */
public class SMSSender implements Sender {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7292651124654093880L;

	public boolean send(MessageInfo message, Server server) {
		return false;
	}

}
