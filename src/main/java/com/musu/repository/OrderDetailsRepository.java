package com.musu.repository;

import com.musu.model.OrderDetailsEntity;
import com.musu.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long>{
     @Query(value = "select d from OrderDetailsEntity d where d.ordersEntity.orderId=?1")
    List<OrderDetailsEntity> findDetailsbyOrderID(int orderID);

}
