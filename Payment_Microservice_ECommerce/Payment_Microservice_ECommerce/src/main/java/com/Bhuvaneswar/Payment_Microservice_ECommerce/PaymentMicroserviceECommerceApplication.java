package com.Bhuvaneswar.Payment_Microservice_ECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PaymentMicroserviceECommerceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(PaymentMicroserviceECommerceApplication.class, args);
	}

}
