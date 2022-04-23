package com.jumponit.reviews;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewsAPIController {

    @Autowired
    private ReviewsRepository repository;

    @GetMapping("/api/reviews")
    public List<Review> listReviews(@RequestParam(name = "id", required = true) String id, Model model) {
        return new ArrayList<>(repository
                .findAllByClassID(Integer.parseInt(id)));
    }

}
