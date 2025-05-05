package com.keralakitchen.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.keralakitchen.Delivery"})
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}

}
