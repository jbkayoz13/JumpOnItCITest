package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MicroserviceController {
	
	RestTemplate template = new RestTemplate();

	@GetMapping("/registration/micro")
	public ClassAndReview[] getOpenClasses() {
		return ListService.getClassesAndReviews();
		
	}
}
