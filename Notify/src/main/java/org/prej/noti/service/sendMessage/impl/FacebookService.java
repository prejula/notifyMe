package org.prej.noti.service.sendMessage.impl;

import java.util.List;

import org.prej.noti.message.MessageInfo;
import org.prej.noti.service.sendMessage.SendMessageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facebook")
public class FacebookService implements SendMessageService{

	@RequestMapping(value = "/SendFBPost", method = RequestMethod.POST)
	public void sendMessage(List<MessageInfo> messageInfoList) {

	//facebook.pageOperations().post();
		
		
	}
	
	@RequestMapping(value ="/helloFacebook", method=RequestMethod.GET)
    public String helloFacebook(Model model) {
		
      
        return "hello";
    }

}
