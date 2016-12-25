package com.musu.service;

import com.musu.model.ProductcategoriesEntity;
import com.musu.repository.ProductcategoriesRepository;
import com.musu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
        @Autowired
    private ProductcategoriesRepository categoryRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(ProductcategoriesEntity user) {

    }

    @Override
    public List<ProductcategoriesEntity> findAll() {
        return  categoryRepository.findAll();
    }

    @Override
    public ProductcategoriesEntity findCategoryByName(String name) {
        return  categoryRepository.findCategoryByName(name);
    }
}
