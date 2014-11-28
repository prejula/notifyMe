package org.prej.noti.service.sendMessage.impl;

import java.util.List;

import javax.inject.Inject;

import org.prej.noti.facebook.connect.FacebookConnector;
import org.prej.noti.message.MessageInfo;
import org.prej.noti.service.sendMessage.SendMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facebook")
public class FacebookService implements SendMessageService {

	private FacebookConnector facebookConnector;

	@Inject
	public FacebookService(FacebookConnector facebookConnector) {
		this.facebookConnector = facebookConnector;
	}

	@RequestMapping(value = "/SendFBPost", method = RequestMethod.POST)
	public void sendMessage(List<MessageInfo> messageInfoList) {

		// facebook.pageOperations().post();

	}

	/**
	 * Used to connect to facebook
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/helloFacebook", method = RequestMethod.GET)
	public String helloFacebook() {

		facebookConnector.connect();

		return "hello";
	}

}
