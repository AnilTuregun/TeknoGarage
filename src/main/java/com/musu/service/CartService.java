package com.musu.service;

import com.musu.model.ProductsEntity;
import com.musu.model.ShoppingCart;

import java.util.List;

public interface CartService {
    void save(ShoppingCart cart);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findCartByUser(String name);
    List<ShoppingCart> findCartProductByProductId(String name,int id);
    void update(int quantity,int id);
}
