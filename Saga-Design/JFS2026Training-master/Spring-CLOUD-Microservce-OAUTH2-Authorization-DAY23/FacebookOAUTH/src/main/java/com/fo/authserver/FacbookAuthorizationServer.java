package com.fo.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class FacbookAuthorizationServer  extends AuthorizationServerConfigurerAdapter{

	private static String REALM="MY_OAUTH_REALM";
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	//@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		//Who is the Client - Temple RUN
		//Client Profile will get configured
		clients.inMemory()
		.withClient("temple-run-client")//Declaring the Client Name
		.authorizedGrantTypes("password","refresh_token","implicit")
		.authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
		.scopes("read","write","trust")
		.secret(bCryptPasswordEncoder.encode("secret"))
		.accessTokenValiditySeconds(60);//Valid for 1 minute
		//.refreshTokenValiditySeconds(600);
		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.tokenStore(tokenStore) //default token store (we can customize the token store)
		.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.realm(REALM+"/client");
	}
	
}
