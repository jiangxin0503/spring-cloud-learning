package com.xin.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApp.class, args);
	}

/*	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

/*		@Autowired
		private PasswordEncoder passwordEncoder;

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {

			UserDetails userDetails = User.withUsername("user").password(passwordEncoder.encode("123456")).roles("ADMIN")
					.build();
			 auth.inMemoryAuthentication().withUser(userDetails);
		}*/

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
			//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
			http.csrf().ignoringAntMatchers("/eureka/**").and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
		}
	}

}
