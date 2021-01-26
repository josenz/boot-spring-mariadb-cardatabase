package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication {

	// Next, we have to inject our car repository into the main class to be 
	//   able to save new 'car' objects to the database. An '@Autowired' 
	//   annotation is used to enable dependency injection. The dependency
	//   injection allows us to pass dependencies into an object.

	@Autowired
	private CarRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	 // After we injected the repository class, we can use the CRUD methods
	//   it provides. The following sample code shows how to insert a few cars
	//   to the database:

	@Bean

	CommandLineRunner runner(){
		return args -> {
			// Save demo data to database
			repository.save(new Car("Ford", "Mustang", "Red",
			"ADF-1121", 2017, 59000));
			repository.save(new Car("Nissan", "Leaf", "White",
			"SSJ-3002", 2014, 29000));
			repository.save(new Car("Toyota", "Prius", "Silver",
			"KKO-0212", 2018, 39000));
		};
	}
}
