package com.scm.config;

//import java.beans.Customizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDeatilsManager;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.imple.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig {
   // user create and login using java code with in memory service
	//private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("admin123").password("admin")
//				.roles("ADMIN","USER")
//				.build();
//		UserDetails user2 = User
//				.withDefaultPasswordEncoder()
//				.username("Barsa").password("barsa")
//				//.roles("ADMIN","USER")
//				.build();
//		var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
//		
//		return inMemoryUserDetailsManager;
//	}
	@Autowired
	private SecurityCustomUserDetailsService userDetailsService;
	
	//configuration of 
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		//user details service ka object
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		//password encoder ka object 
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		//configuration
		//configure urls which will be public and which will be private
		httpSecurity.authorizeHttpRequests(authorize->{
			//authorize.requestMatchers("/home", "/register", "/services").permitAll();
			authorize.requestMatchers("/user/**").authenticated();
			authorize.anyRequest().permitAll();
		});
		
		//form default login
		httpSecurity.formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
