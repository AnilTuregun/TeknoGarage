package com.musu.repository;


import com.musu.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("select s from ShoppingCart s,User  u where s.user.username = ?1 and s.user.id=u.id")
    List<ShoppingCart> findCartByUser(String name);

    @Modifying
    @Query("select s from ShoppingCart s,User  u where s.user.username = ?1 and s.product.id=?2 and s.user.id=u.id")
    List<ShoppingCart> findCartProductByProductId(String name,int productId);

    @Modifying
    @Query("select s from ShoppingCart s,User  u where s.user.username = ?1 and s.product.productName=?2 and s.user.id=u.id")
    List<ShoppingCart> findCartProductByProductName(String uname,String pname);
    /*@Query("update ShoppingCart s set s.quantity =?1 where s.id=?2")
   void updateShopingCart(int quantity,int sId);*/
    @Transactional
    @Modifying
    @Query("UPDATE ShoppingCart s SET s.quantity = :quantity WHERE s.id = :sId")
    int updateShopingCart(@Param("quantity") int quantity, @Param("sId") int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShoppingCart s WHERE s.id = :sId")
    int deleteItemFromCart(@Param("sId") int id);
}
