package com.musu.service;

import com.musu.model.ProductcategoriesEntity;

import java.util.List;

public interface CategoryService {
    void save(ProductcategoriesEntity user);


    List<ProductcategoriesEntity> findAll();
    ProductcategoriesEntity findCategoryByName(String name);
}
