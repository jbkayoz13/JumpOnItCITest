package com.jumponit.reviews;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	@Bean
	public ApplicationRunner init(ReviewsRepository repository) {

		List<Review> data = new ArrayList<Review>();
		data.add(new Review(5.0, "Great course", 1, 1));
		data.add(new Review(3.0, "It was okay", 1, 1));
		data.add(new Review(2.0, "Terrible course, would not take it again!", 1, 1));
		data.add(new Review(5.0, "I liked this course", 1, 2));
		data.add(new Review(3.0, "It was amazing", 1, 2));

		repository.deleteAll();

		return args -> {
			data.forEach(review -> {
				repository.save(review);
			});
		};
	}

}
