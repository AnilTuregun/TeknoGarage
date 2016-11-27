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

    }

    @Override
    public List<ProductsEntity> findAll() {
        return  productsRepository.findAll();
    }

    @Override
    public List<ProductsEntity> findByCateogoryId(int id) {
        return productsRepository.findByProductsByProductCategoryId(id);
    }
}
