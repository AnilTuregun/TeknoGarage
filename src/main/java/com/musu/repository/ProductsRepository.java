package com.musu.repository;

import com.musu.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{

    @Query("select p from ProductsEntity p,ProductcategoriesEntity c where p.productcategoriesByProductCategoryId.categoryId = ?1 and p.productcategoriesByProductCategoryId.categoryId=c.categoryId")
    List<ProductsEntity> findByProductsByProductCategoryId(int id);

    @Query("select p from ProductsEntity p,ProductcategoriesEntity c where c.categoryName = ?1 and p.productcategoriesByProductCategoryId.categoryId=c.categoryId")
    List<ProductsEntity> findByCateogoryName(String name);

    @Query("select p from ProductsEntity p where p.productName = ?1")
    ProductsEntity findByName(String name);

    @Query("select p from ProductsEntity p where p.productTags like LOWER(CONCAT('%',:tags, '%'))")
    List<ProductsEntity> searchProductContaining(@Param("tags")String name);

    @Transactional
    @Modifying
    @Query("UPDATE ProductsEntity p SET p.productName=:pName,p.productLongDesc=:pDesc,p.productImage=:pImg,p.productStock=:pStock,p.productPrice=:pPrice,p.productTags=:pTag WHERE p.productId = :pId")
    int updateProduct( @Param("pName") String Name,@Param("pDesc") String pDesc,@Param("pImg") String pImg,@Param("pStock")double pStok,@Param("pPrice") double pPrice,@Param("pTag") String pTag);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductsEntity p WHERE p.productId = ?1")
    int deleteProduct(int id);
}

