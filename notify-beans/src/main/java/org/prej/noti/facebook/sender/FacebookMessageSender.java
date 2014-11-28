package org.prej.noti.facebook.sender;

import javax.inject.Inject;

import org.prej.noti.Server;
import org.prej.noti.message.MessageInfo;
import org.prej.noti.sender.Sender;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.ui.Model;

public class FacebookMessageSender implements Sender {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3783771747672620906L;

	private Facebook facebook = null;

	@Inject
	public FacebookMessageSender(Facebook facebook) {
		this.facebook = facebook;
	}

	public boolean send(MessageInfo message, Server server) {
		// TODO Auto-generated method stub
		return false;
	}

	public String helloFacebook(Model model) {
		/*
		 * if (!facebook.isAuthorized()) { return "redirect:/connect/facebook";
		 * }
		 */

		model.addAttribute(facebook.userOperations().getUserProfile());
		PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
		model.addAttribute("feed", homeFeed);

		return "hello";

	}
}
