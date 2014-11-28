package org.prej.noti.service.sender;

import org.prej.noti.sender.Sender;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationSenderService {

	@RequestMapping(value = "/AddNotificationSender", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addSender(@RequestParam(required = true) Sender sender) {
		System.out.println("Sender added");

	}

	@RequestMapping(value = "/RemoveNotificationSender", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String removeNotificationSender() {
		System.out.println("Sender removed");
		return "hello";
	}

}
