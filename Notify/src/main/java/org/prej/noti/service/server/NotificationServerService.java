package org.prej.noti.service.server;

import org.prej.noti.Server;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationServerService {

	@RequestMapping(value = "/addNotificationServer", method = RequestMethod.POST)
	public void addNotificationServer(@RequestParam(required=true) Server server)
	{
		
	}
	
	@RequestMapping(value = "/removeNotificationServer", method = RequestMethod.DELETE)
	public void removeNotificationServer(@RequestParam(required=true) Server server)
	{
		
	}
}
