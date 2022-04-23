package com.jumponit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ReviewsController {

    @Autowired
    private ReviewsRepository repository;

    @GetMapping("/")
    public String listReviews(@RequestParam(name = "id", required=false, defaultValue="1") String id, Model model) {
        prepareView(Integer.parseInt(id), model);

        return "reviews";
    }

    @PostMapping("/create/review")
    public String addReview(Review review, Model model) {
        repository.save(review);
        prepareView(review.getClassID(), model);
        return "reviews";
    }

    private void prepareView(int id, Model model) {
        List<Review> reviews = repository.findAllByClassID(id);
        Review newReview = new Review();
        model.addAttribute("reviews", reviews);
        model.addAttribute("newReview", newReview);
    }
}
