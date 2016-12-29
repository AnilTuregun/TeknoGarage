package com.musu.service;

import com.musu.model.Reviews;
import com.musu.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public List<Reviews> findAll() {
        return reviewRepository.findAll();
    }
    @Override
    public void save(Reviews reviews) {
        reviewRepository.save(reviews);
    }
    @Override
    public List<Reviews> findReviewsByProductId(int id) {
        return reviewRepository.findReviewByProductId(id);
    }
}
