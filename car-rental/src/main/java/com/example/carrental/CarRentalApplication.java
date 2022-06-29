package com.example.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);
		CocheRepo repo = context.getBean(CocheRepo.class);

		Coche toyota = new Coche(1L, "Toyota", "Prius", 2010);
		repo.save(toyota);


	}

}
