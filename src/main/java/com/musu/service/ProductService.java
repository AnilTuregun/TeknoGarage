package com.musu.service;

import com.musu.model.ProductsEntity;

import java.util.List;

public interface ProductService {
    void save(ProductsEntity product);


    List<ProductsEntity> findAll();
    List<ProductsEntity> findAllDesc();
    List<ProductsEntity> findByCateogoryId(int id);
    List<ProductsEntity> findByCateogoryName(String name);
    List<ProductsEntity> searchProduct(String name);
    ProductsEntity findByName(String name);
    ProductsEntity findBySkuNumber(String Sku);
    List<ProductsEntity> findByNameOrderDesc(String name);
    List<ProductsEntity> findByNameOrderAsc(String name);
    void deleteProduct(int id);
    void editProduct(ProductsEntity productsEntity);
}
