package org.prej.noti.service.sendMessage;

import java.util.List;

import org.prej.noti.message.MessageInfo;
import org.springframework.web.bind.annotation.RequestParam;

public interface SendMessageService {

	public void sendMessage(
			@RequestParam(required = true) List<MessageInfo> messageInfoList);
}
