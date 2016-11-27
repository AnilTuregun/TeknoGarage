package com.musu.repository;

import com.musu.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

    @Query("select p from ProductsEntity p,ProductcategoriesEntity c where p.productcategoriesByProductCategoryId.categoryId = ?1 and p.productcategoriesByProductCategoryId.categoryId=c.categoryId")
    List<ProductsEntity> findByProductsByProductCategoryId(int id);
}

