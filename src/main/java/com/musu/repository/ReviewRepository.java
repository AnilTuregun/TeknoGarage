package com.musu.repository;


import com.musu.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {

    @Query("select r from Reviews r,ProductsEntity p where r.productsEntity.productId= :id and r.productsEntity.productId=p.productId")
    List<Reviews> findReviewByProductId(@Param("id") int id);
    @Query("select r from Reviews r where r.id= :id")
    Reviews findReviewById(@Param("id") int id);
    @Transactional
    @Modifying
    @Query("DELETE FROM Reviews r WHERE r.id = ?1")
    int deleteReview(int id);
}
