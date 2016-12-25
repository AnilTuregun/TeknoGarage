package com.musu.repository;

import com.musu.model.ProductcategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductcategoriesRepository extends JpaRepository<ProductcategoriesEntity, Long>{
    @Query("select c from ProductcategoriesEntity c where c.categoryName = ?1")
    ProductcategoriesEntity findCategoryByName(String name);

}
