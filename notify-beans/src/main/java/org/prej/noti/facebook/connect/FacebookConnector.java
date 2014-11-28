package org.prej.noti.facebook.connect;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.prej.noti.connector.Connector;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;

@Configuration
public class FacebookConnector implements Connector, SocialConfigurer {

	private ConnectionFactoryRegistry registry = null;

	public void connect() {

		connectionFactoryLocator("731667440241867",
				"6352f4598b9062bf1b2f5c34e7f21853");
		/*
		 * environment .getProperty("facebook.clientId"), environment
		 * .getProperty("facebook.clientSecret")
		 */

		// registry.getConnectionFactory("").createConnection("");

	}

	private void connectionFactoryLocator(String appId, String secretKey) {

		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(
				appId, secretKey);

		OAuth2Operations oauthOperations = connectionFactory
				.getOAuthOperations();

		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://localhost:28082/notify/facebook/helloFacebook");

		String authorizeUrl = oauthOperations.buildAuthorizeUrl(
				GrantType.AUTHORIZATION_CODE, params);

		System.out.println("authorizeUrl ::::::: " + authorizeUrl);

		//HttpHost proxy = new HttpHost("www-proxy.idc.oracle.com", 80);

		HttpClient httpClient = new DefaultHttpClient();
		//httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
			//	proxy);

		HttpGet httpGet = new HttpGet(authorizeUrl);

		try {
			HttpResponse response = httpClient.execute(httpGet);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// upon receiving the callback from the provider:
		AccessGrant accessGrant = oauthOperations.exchangeForAccess("",
				"http://localhost:28082/notify/facebook/helloFacebook", null);
		Connection<Facebook> connection = connectionFactory
				.createConnection(accessGrant);

		registry.addConnectionFactory(connectionFactory);
	}

	public void addConnectionFactories(
			ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		// TODO Auto-generated method stub

	}

	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public UsersConnectionRepository getUsersConnectionRepository(
			ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO Auto-generated method stub
		return null;
	}

}
