/**
 * 
 */
package org.prej.noti.sender;

import java.io.Serializable;

import org.prej.noti.Server;
import org.prej.noti.message.MessageInfo;

/**
 * @author ppp
 *
 */
public interface Sender extends Serializable{

	public boolean send(MessageInfo message, Server server);
}
