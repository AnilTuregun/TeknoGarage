package com.musu.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "products", schema = "mydatabase", catalog = "")
public class ProductsEntity {
    private int productId;
    private String productSku;
    private String productName;
    private double productPrice;
    private double productWeight;
    private String productCartDesc;
    private String productShortDesc;
    private String productLongDesc;
    private String productImage;
    private Timestamp productUpdateDate;
    private Double productStock;
    private Byte productLive;
    private Byte productUnlimited;
    private String productTags;
    private Set<ShoppingCart> shoppingCarts;
    private Set<Reviews> reviews;
    private ProductcategoriesEntity productcategoriesByProductCategoryId;




    @Id
    @Column(name = "ProductID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ProductSKU")
    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    @Basic
    @Column(name = "ProductName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "ProductPrice")
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "ProductWeight")
    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    @Basic
    @Column(name = "ProductCartDesc")
    public String getProductCartDesc() {
        return productCartDesc;
    }

    public void setProductCartDesc(String productCartDesc) {
        this.productCartDesc = productCartDesc;
    }

    @Basic
    @Column(name = "ProductShortDesc")
    public String getProductShortDesc() {
        return productShortDesc;
    }

    public void setProductShortDesc(String productShortDesc) {
        this.productShortDesc = productShortDesc;
    }

    @Basic
    @Column(name = "ProductLongDesc")
    public String getProductLongDesc() {
        return productLongDesc;
    }

    public void setProductLongDesc(String productLongDesc) {
        this.productLongDesc = productLongDesc;
    }

    @Basic
    @Column(name = "ProductImage")
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Basic
    @Column(name = "ProductUpdateDate")
    public Timestamp getProductUpdateDate() {
        return productUpdateDate;
    }

    public void setProductUpdateDate(Timestamp productUpdateDate) {
        this.productUpdateDate = productUpdateDate;
    }

    @Basic
    @Column(name = "ProductStock")
    public Double getProductStock() {
        return productStock;
    }

    public void setProductStock(Double productStock) {
        this.productStock = productStock;
    }

    @Basic
    @Column(name = "ProductLive")
    public Byte getProductLive() {
        return productLive;
    }

    public void setProductLive(Byte productLive) {
        this.productLive = productLive;
    }

    @Basic
    @Column(name = "ProductUnlimited")
    public Byte getProductUnlimited() {
        return productUnlimited;
    }

    public void setProductUnlimited(Byte productUnlimited) {
        this.productUnlimited = productUnlimited;
    }

    @Basic
    @Column(name = "ProductTags")
    public String getProductTags() {
        return productTags;
    }

    public void setProductTags(String productTags) {
        this.productTags = productTags;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    public Set<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @OneToMany(mappedBy = "productsEntity", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (productId != that.productId) return false;
        if (Double.compare(that.productPrice, productPrice) != 0) return false;
        if (Double.compare(that.productWeight, productWeight) != 0) return false;
        if (productSku != null ? !productSku.equals(that.productSku) : that.productSku != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productCartDesc != null ? !productCartDesc.equals(that.productCartDesc) : that.productCartDesc != null)
            return false;
        if (productShortDesc != null ? !productShortDesc.equals(that.productShortDesc) : that.productShortDesc != null)
            return false;
        if (productLongDesc != null ? !productLongDesc.equals(that.productLongDesc) : that.productLongDesc != null)
            return false;
        if (productImage != null ? !productImage.equals(that.productImage) : that.productImage != null) return false;
        if (productUpdateDate != null ? !productUpdateDate.equals(that.productUpdateDate) : that.productUpdateDate != null)
            return false;
        if (productStock != null ? !productStock.equals(that.productStock) : that.productStock != null) return false;
        if (productLive != null ? !productLive.equals(that.productLive) : that.productLive != null) return false;
        if (productUnlimited != null ? !productUnlimited.equals(that.productUnlimited) : that.productUnlimited != null)
            return false;
        if (productTags != null ? !productTags.equals(that.productTags) : that.productTags != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId;
        result = 31 * result + (productSku != null ? productSku.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(productWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productCartDesc != null ? productCartDesc.hashCode() : 0);
        result = 31 * result + (productShortDesc != null ? productShortDesc.hashCode() : 0);
        result = 31 * result + (productLongDesc != null ? productLongDesc.hashCode() : 0);
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        result = 31 * result + (productUpdateDate != null ? productUpdateDate.hashCode() : 0);
        result = 31 * result + (productStock != null ? productStock.hashCode() : 0);
        result = 31 * result + (productLive != null ? productLive.hashCode() : 0);
        result = 31 * result + (productUnlimited != null ? productUnlimited.hashCode() : 0);
        result = 31 * result + (productTags != null ? productTags.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "CategoryID", nullable = false)
    public ProductcategoriesEntity getProductcategoriesByProductCategoryId() {
        return productcategoriesByProductCategoryId;
    }

    public void setProductcategoriesByProductCategoryId(ProductcategoriesEntity productcategoriesByProductCategoryId) {
        this.productcategoriesByProductCategoryId = productcategoriesByProductCategoryId;
    }
}
