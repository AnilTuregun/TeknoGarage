package com.musu.service;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.Reviews;

import java.util.List;

public interface ReviewService {
    void save(Reviews reviews);
    List<Reviews> findAll();
    List<Reviews> findReviewsByProductId(int id);
    void deleteComment(int id);
    Reviews findById(int id);
    Reviews findReview(int id);


}
