package org.prej.noti.service.sendMessage.impl;

import java.util.List;

import org.prej.noti.message.MessageInfo;
import org.prej.noti.service.sendMessage.SendMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TwitterService implements SendMessageService {

	@RequestMapping(value = "/SendTweet", method = RequestMethod.POST)
	public void sendMessage(List<MessageInfo> messageInfoList) {
		// TODO Auto-generated method stub

	}

}
