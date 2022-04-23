package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Swe443RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Swe443RegistrationApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner init(RegistrationRepository repository) {

		int[][] data = {  {1, 2}, {1, 3}, {1,4}  };
	
		repository.deleteAll();
		
	    return args -> {
	      Stream.of(data).forEach(array -> {
	        Registration reg = new Registration(
	              array[0],
	              array[1]
	          );
	          repository.save(reg);
	      });
	    };
	}

}
