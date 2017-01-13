package com.musu.repository;

import com.musu.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long>{


    @Query(value = "select o from OrdersEntity o,User  u where o.userId.username = ?1 and o.userId.id=u.id ")
    List<OrdersEntity>  findOrdersbyUsername(String name);
}