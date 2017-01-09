package com.musu.service;


import com.musu.model.ProductsEntity;
import com.musu.repository.ProductsRepository;
import com.musu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
        @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(ProductsEntity product) {

        productsRepository.save(product);
    }

    @Override
    public List<ProductsEntity> findAll() {
        return  productsRepository.findAll();
    }

    @Override
    public List<ProductsEntity> findByCateogoryId(int id) {
        return productsRepository.findByProductsByProductCategoryId(id);
    }

    @Override
    public List<ProductsEntity> findByCateogoryName(String name) {
        return productsRepository.findByCateogoryName(name);
    }

    @Override
    public List<ProductsEntity> searchProduct(String name) {
        return productsRepository.searchProductContaining(name);
    }

    @Override
    public ProductsEntity findByName(String name) {
        return  productsRepository.findByName(name);
    }

    @Override
    public void deleteProduct(int id) {
        productsRepository.deleteProduct(id);

    }
}
