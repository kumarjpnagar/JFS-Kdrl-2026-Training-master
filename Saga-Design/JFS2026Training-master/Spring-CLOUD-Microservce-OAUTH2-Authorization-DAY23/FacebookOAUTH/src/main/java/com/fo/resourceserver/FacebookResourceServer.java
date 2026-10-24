package com.fo.resourceserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
//we need to enable he Resource Server
@EnableResourceServer
public class FacebookResourceServer extends ResourceServerConfigurerAdapter  {

	private static final String RESOURCE_ID = "my_rest_api";
	
	//Optional Step
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/welcome") //welcome endpoint is protected
		//.access("hasRole('ADMIN')")
		.hasAnyRole("ADMIN")
		.anyRequest().authenticated();
	}
}

