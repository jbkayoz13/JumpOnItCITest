package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller // For the microservice, which will be a REST api, you'll use @RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationRepository repository;
	
	@GetMapping("/registration")
	public String getOpenRegistrations(@RequestParam(name="id", required=false, defaultValue="1") String id, Model model) {
		prepareView(id, model);		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(Registration reg, Model model) {
		repository.save(reg);
		
		prepareView(Long.toString(reg.getMemberID()), model);
		
		return "registration";
	}
	
	private void prepareView(String id, Model model) {
		List<Registration> regs = repository.findAllByMemberID(Long.parseLong(id));
		List<Long> classIDs = new ArrayList<>();
		
		for (Registration reg : regs) {
			classIDs.add(reg.getClassID());
		}
		
		String uri = "http://localhost:8082/registration/micro";
		RestTemplate template = new RestTemplate();
	
		ResponseEntity<ClassAndReview[]> response = template.getForEntity(uri, ClassAndReview[].class);
		List<ClassAndReview> data = new ArrayList<>(Arrays.asList(response.getBody()));

		
		for (int i = data.size() - 1; i >= 0; i--) {
			if (classIDs.contains(data.get(i).getClassID()))
				data.remove(i);
		}

		Registration newby = new Registration();
		
		model.addAttribute("registration", newby);
		model.addAttribute("data", data);
	}
	
}
