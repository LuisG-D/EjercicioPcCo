package com.example.pccom;

import com.example.pccom.entities.Laptop;
import com.example.pccom.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
public class PccomApplication {

	public static void main(String[] args) {

		ApplicationContext cont = SpringApplication.run(PccomApplication.class, args);
		LaptopRepository repo = cont.getBean(LaptopRepository.class);


		Laptop laptop1 = new Laptop(null, "Asus", "Rog Strix", "Create for Gamers", 500, 24);
		repo.save(laptop1);
		Laptop laptop2 = new Laptop(null, "Lenovo", "Rog Strix", "Create for Gamers", 500, 24);
		repo.save(laptop2);
		Laptop laptop3 = new Laptop(null, "AMD", "Rog Strix", "Create for Gamers", 500, 24);
		repo.save(laptop3);


	}

}
