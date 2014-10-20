/**
 * 
 */
package org.prej.noti.sender.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.prej.noti.Server;
import org.prej.noti.message.EmailMessageInfo;
import org.prej.noti.message.MessageInfo;
import org.prej.noti.sender.Sender;

/**
 * @author ppp
 *
 */
public class EmailSender implements Sender {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3097701603687534948L;

	public boolean send(MessageInfo messageInfo, final Server server) {
		
		EmailMessageInfo emailMessageInfo = null;
		 if(messageInfo instanceof EmailMessageInfo)
		 {
			 emailMessageInfo = (EmailMessageInfo)messageInfo;
		 }
		
		  Session session = createSession(server);

	      try {
		   
	    	  Message message = createMimeMessage(emailMessageInfo, session);

		   // Send message
		   Transport.send(message);

	      }catch (UnsupportedEncodingException e) {
		         throw new RuntimeException(e);
		  } 
	      catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
		
		return false;
	}

	private Session createSession(final Server server) {
		Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", server.getHostName());
	      props.put("mail.smtp.port", server.getPort());

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(server.getUserName(), server.getPassword());
		   }
	         });
		return session;
	}

	private Message createMimeMessage(EmailMessageInfo emailMessageInfo,
			Session session) throws MessagingException, AddressException,
			UnsupportedEncodingException {
		// Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(emailMessageInfo.getSender()));
		
		   int size = emailMessageInfo.getReceiver().size() ;
		   InternetAddress[] recipient = new InternetAddress[size];
		   
		   createInternetAddress(emailMessageInfo, size, recipient);
		   		     
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO, recipient);
		
		   // Set Subject: header field
		   message.setSubject(emailMessageInfo.getSubject());
		
		   // Now set the actual message
		   message.setText(emailMessageInfo.getMessage());
		return message;
	}

	private void createInternetAddress(EmailMessageInfo emailMessageInfo,
			int size, InternetAddress[] recipient)
			throws UnsupportedEncodingException {
		for (int i=0 ; i<= size; i ++)
		   {
			   InternetAddress internetAddress = new InternetAddress();
			   internetAddress.setAddress(emailMessageInfo.getReceiver().get(i).getAddress());
			   internetAddress.setPersonal(emailMessageInfo.getReceiver().get(i).getName(), "UTF-8");
			   
			   recipient[i] = internetAddress;
		   }
	}

	

}
