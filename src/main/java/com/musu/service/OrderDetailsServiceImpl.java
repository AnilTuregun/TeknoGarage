package com.musu.service;

import com.musu.model.OrderDetailsEntity;
import com.musu.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ortayol on 11.01.2017.
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public void save(OrderDetailsEntity orderDetailsEntity){
        orderDetailsRepository.save(orderDetailsEntity);}

    @Override
    public List<OrderDetailsEntity> findDetailsbyOrderID(int orderID) {
        return orderDetailsRepository.findDetailsbyOrderID(orderID);
    }
}
