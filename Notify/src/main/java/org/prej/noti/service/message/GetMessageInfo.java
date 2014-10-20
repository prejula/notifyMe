package org.prej.noti.service.message;

import org.prej.noti.message.MessageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GetMessageInfo")
public class GetMessageInfo {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public MessageInfo getMessageInfo(@RequestParam(required=true)String msgId)
	{
		System.out.println("Message Info sent");
		MessageInfo message = new MessageInfo();
		return message;
	}

}
