package com.musu.repository;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductcategoriesRepository extends JpaRepository<ProductcategoriesEntity, Long>{
    @Query("select c from ProductcategoriesEntity c where c.categoryName = ?1")
    ProductcategoriesEntity findCategoryByName(String name);
}
