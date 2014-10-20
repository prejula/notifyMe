package org.prej.noti.service.sender;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RemoveNotificationSender")
public class RemoveNotificationSender {
	
	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public String removeNotificationSender()
	{
		System.out.println("Sender removed");
		return "hello";
	}

}
