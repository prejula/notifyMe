package org.prej.noti.service.sendMessage;

import org.prej.noti.message.MessageInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface SendMessageService {

	public void sendMessage(@RequestParam(required=true) MessageInfo messageInfo);
}