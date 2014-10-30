package org.prej.noti.service.sendMessage.impl;

import javax.inject.Inject;

import org.prej.noti.message.MessageInfo;
import org.prej.noti.service.sendMessage.SendMessageService;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facebook")
public class FacebookService implements SendMessageService{

	private Facebook facebook = null;
	
	@Inject
	public FacebookService(Facebook facebook) {
		this.facebook = facebook;
	}
	
	
	@RequestMapping(value = "/SendFBPost", method = RequestMethod.POST)
	public void sendMessage(MessageInfo messageInfo) {

	//	facebook.post(arg0, arg1, arg2);
		
	}
	
	@RequestMapping(value ="/helloFacebook", method=RequestMethod.GET)
    public String helloFacebook(Model model) {
		
        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
        model.addAttribute("feed", homeFeed);

        return "hello";
    }

}
