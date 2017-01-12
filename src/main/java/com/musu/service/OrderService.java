package com.musu.service;

import com.musu.model.OrdersEntity;
import com.musu.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    void save(OrdersEntity ordersEntity);
    void saveAndFlush(OrdersEntity or);

    List<OrdersEntity> findOrdersbyUsername(String name);
    List<OrdersEntity> findAll();
}
