package com.fo.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class FacebookWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Bean
	public TokenStore tokenStore() {
		//In-Memory Toke Store
		//Will help us in generating the JSON Tokens
		//With that Token Temple RUn can access your 
		//FB Page to post the score
		
		return new InMemoryTokenStore();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("sabari").password(bCryptPasswordEncoder.encode("abc1234"))
		.roles("ADMIN").and()
		.withUser("sundarpichai").password(bCryptPasswordEncoder.encode("abc1234"))
		.roles("USER");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/oauth/token").permitAll()
		.and()
		.csrf()
		.disable()
		.anonymous()
		.disable();
		
	}
	
}
