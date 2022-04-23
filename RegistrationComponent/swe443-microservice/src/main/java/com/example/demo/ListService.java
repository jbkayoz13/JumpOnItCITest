package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Still need to be provided with the ClassManagement and Review definitions
 * and to confirm team members' APIs for correct call.
 * 
 */
@Service
public class ListService {
	public static ClassAndReview[] getClassesAndReviews() {
		String classURI = "http://localhost:7777/classes";
//		String reviewURIBase = "http://localhost:8088/reviews/";

		RestTemplate template = new RestTemplate();
		ResponseEntity<ClassManagement[]> classResponse = template.getForEntity(classURI, ClassManagement[].class);
		List<ClassManagement> classes = Arrays.asList(classResponse.getBody());
		
		ClassAndReview[] data = new ClassAndReview[classes.size()];
		
		for (int i = 0; i < data.length; i++) {
			ClassManagement clss = classes.get(i);
			data[i] = new ClassAndReview();
			data[i].setClassID(clss.getClassID());
			data[i].setDate(clss.getClassDate());
			data[i].setLocation(clss.getClassLocation());
			data[i].setName(clss.getClassName());
			
			//delete later
			data[i].setReviewRating(3);
			
//			String reviewURI = reviewURIBase + "{" + data[i].getClassID() + "}";
//			
//			ResponseEntity<Review[]> revResponse = template.getForEntity(reviewURI, review[].class);
//			Review[] reviews = revResponse.getBody();
//			double sum = 0;
//			
//			for (Review rev : reviews) {
//				sum += rev.getRating();
//			}
//			
//			data[i].setReviewRating(sum / reviews.length);
		}
		
		return data;
//		return dumbyDumbDumb();
	}
	
	/*
	private static ClassAndReview[] dumbyDumbDumb() {
		ClassAndReview[] data = new ClassAndReview[6];
		String name = "Class No - ";
		String location = "Location No - ";
		
		for (int i = 0; i < data.length; i++) {
			data[i] = new ClassAndReview();
			data[i].setClassID(i + 1);
			data[i].setName(name + i + 1);
			data[i].setDate(new Date());
			data[i].setLocation(location + i + 1);
			data[i].setReviewRating((int) (Math.random() * 5) + 1);
		}
		return data;
	}
	*/
}

