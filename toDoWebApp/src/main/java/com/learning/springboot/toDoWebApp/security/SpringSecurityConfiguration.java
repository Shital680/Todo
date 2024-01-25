package com.learning.springboot.toDoWebApp.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		 
//		String username = "Shital"; 
		UserDetails userDetails1 = userDetailsManager("Shital", "12345");
		UserDetails userDetails2 = userDetailsManager("Raj", "12345");
		UserDetails userDetails3 = userDetailsManager("Ram", "12345");
		return new InMemoryUserDetailsManager(userDetails1 , userDetails2,userDetails3);
		
	}

	private UserDetails userDetailsManager(String username, String password) {
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails =User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//All url's are protected
	//A login form is shown for unauthorised requests
	//csrf disable
	//frames
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
