package com.rba.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class RoomBookingSecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//Authorization Constraints
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//1. Allows restricting access based upon the HttpServletRequest using RequestMatcher 
		http.authorizeRequests()
		.mvcMatchers(HttpMethod.GET, "/api/welcome").permitAll()
		.mvcMatchers(HttpMethod.GET,"/api/rooms").hasAnyRole("USER")
		.mvcMatchers(HttpMethod.GET,"/api/rooms/id/{roomId}").hasAnyRole("USER","ADMIN")
		.mvcMatchers(HttpMethod.GET,"/api/rooms/capacity/{rcapacity}").hasAnyRole("ADMIN")
		.mvcMatchers(HttpMethod.POST,"/api/rooms").hasAnyRole("ADMIN")
		.mvcMatchers(HttpMethod.PUT,"/api/rooms/{roomId}/{roomCapacity}").hasAnyRole("ADMIN")
		.mvcMatchers(HttpMethod.DELETE,"/api/rooms/{roomCapacity}").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.httpBasic();
		//.and()
		//.formLogin();
		//Basic Authentication
		//Form Based Authentication
	}
	
	//How are we going to create the roles and user credentials
	//1. In-Memory Authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication()
		auth.inMemoryAuthentication()
		.withUser("sabari")
		//.password("{noop}sabari")//no password encryption required
		.password(bCryptPasswordEncoder.encode("sabari"))
		.roles("USER")
		.and()
		.withUser("balaji")
		//.password("{noop}balaji")
		.password(bCryptPasswordEncoder.encode("balaji"))
		.roles("USER")
		.and()
		.withUser("sundar")
		//.password("{noop}sundar")
		.password(bCryptPasswordEncoder.encode("sundar"))
		.roles("ADMIN")
		.and()
		.withUser("steve")
		//.password("{noop}steve")
		.password(bCryptPasswordEncoder.encode("steve"))
		.roles("ADMIN")
		.and()
		.withUser("sachin")
		//.password("{noop}sachin")
		.password(bCryptPasswordEncoder.encode("sachin"))
		.roles("USER","ADMIN");
		
	}
}
