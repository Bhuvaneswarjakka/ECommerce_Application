package com.Bhuvaneswar.UserServive.as.a.OAuth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UserServiveAsAOAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserServiveAsAOAuth2Application.class, args);
	}

}
