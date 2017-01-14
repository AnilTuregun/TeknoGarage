package com.musu.service;


import com.musu.model.ProductsEntity;
import com.musu.repository.ProductsRepository;
import com.musu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "productPrice");
    }

    @Override
    public void save(ProductsEntity product) {

        productsRepository.save(product);
    }

    @Override
    public List<ProductsEntity> findAll() {
        return  productsRepository.findAll();
    }

    @Override
    public List<ProductsEntity> findAllDesc() {
        return productsRepository.findAllDesc();
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
    public ProductsEntity findBySkuNumber(String Sku) {
        return productsRepository.findBySkuNumber(Sku);
    }

    @Override
    public List<ProductsEntity> findByNameOrderDesc(String name) {
        return productsRepository.findByNameOrderDesc(name);
    }

    @Override
    public List<ProductsEntity> findByNameOrderAsc(String name) {
        return productsRepository.findByNameOrderAsc(name);
    }

    @Override
    public void deleteProduct(int id) {
        productsRepository.deleteProduct(id);

    }

    @Override
    public void editProduct(ProductsEntity productsEntity) {

        productsRepository.updateProduct(productsEntity.getProductName(),productsEntity.getProductLongDesc(),productsEntity.getProductImage(),productsEntity.getProductStock(),productsEntity.getProductPrice(),productsEntity.getProductTags());
    }
}
