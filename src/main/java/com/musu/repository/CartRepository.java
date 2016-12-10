package com.musu.repository;


import com.musu.model.ShoppingCart;
import com.musu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("select s from ShoppingCart s,User  u where s.user.username = ?1 and s.user.id=u.id")
    List<ShoppingCart> findCartByUser(String name);

    @Query("select s from ShoppingCart s,User  u where s.user.username = ?1 and s.product.id=?2 and s.user.id=u.id")
    List<ShoppingCart> findCartProductByProductId(String name,int productId);

    @Query("update ShoppingCart s set s.quantity =?1 where s.id=?2")
   void updateShopingCart(int quantity,int sId);
}
