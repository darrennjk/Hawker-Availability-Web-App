package com.sc2006.hawker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final MongoTemplate mongoTemplate;

    public ReviewService(MongoTemplate mongoTemplate, ReviewRepository reviewRepository) {
        this.mongoTemplate = mongoTemplate;
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(String reviewBody, String serialno){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Hawker.class)
                .matching(Criteria.where("serialno").is(serialno))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
