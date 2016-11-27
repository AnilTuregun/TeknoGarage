package com.musu.service;

import com.musu.model.ProductsEntity;

import java.util.List;

public interface ProductService {
    void save(ProductsEntity product);


    List<ProductsEntity> findAll();
    List<ProductsEntity> findByCateogoryId(int id);
}
