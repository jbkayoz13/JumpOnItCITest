package com.jumponit.reviews;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByClassID(int classID);
    List<Review> findAll();
}
