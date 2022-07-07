package com.example.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {

	ApplicationContext conte = SpringApplication.run(CarRentalApplication.class, args);
		CocheRepo repo = conte.getBean(CocheRepo.class);

		System.out.println("Cantidad" + repo.count());



	}

}
