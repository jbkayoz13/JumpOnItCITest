package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationAPIController {
	
	@Autowired
	private RegistrationRepository repository;

	@GetMapping("/registration/{id}")
	public String getRegistrations(@PathVariable String id) {
		return Integer.toString(repository.findAllByMemberID(Integer.parseInt(id)).size());
	}
}
