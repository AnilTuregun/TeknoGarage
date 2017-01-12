package com.musu.service;

import com.musu.model.OrderDetailsEntity;

import java.util.List;

/**
 * Created by Ortayol on 11.01.2017.
 */
public interface OrderDetailsService {
    void save (OrderDetailsEntity orderDetailsEntity);
    List<OrderDetailsEntity> findDetailsbyOrderID(int orderID);
}
