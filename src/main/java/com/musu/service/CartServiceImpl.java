package com.musu.service;

import com.musu.model.ProductsEntity;
import com.musu.model.ShoppingCart;
import com.musu.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public void save(ShoppingCart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return  cartRepository.findAll();
    }

    @Override
    public List<ShoppingCart> findCartByUser(String name) {
        return cartRepository.findCartByUser(name);
    }

    @Override
    public List<ShoppingCart> findCartProductByProductId(String name,int id) {
        return cartRepository.findCartProductByProductId(name,id);
    }

    @Override
    public void update(int quantity, int id) {
        cartRepository.updateShopingCart(quantity,id);
    }

    @Override
    public List<ShoppingCart> shoppingCartByName(String name, String uname) {
  return cartRepository.findCartProductByProductName(name, uname);
    }

    @Override
    public void deleteItemFromCart(int id) {
        cartRepository.deleteItemFromCart(id);
    }


    public void delete(ShoppingCart shoppingCart) {
        cartRepository.delete(shoppingCart);
    }
}
