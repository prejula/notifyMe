package org.prej.noti.service.server;

import org.prej.noti.Server;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServerService {
	
	
	
	public void addEmailServer(@RequestParam(required=true) Server server)
	{
		
	}

}
