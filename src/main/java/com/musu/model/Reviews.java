package com.musu.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by User on 22.12.2016.
 */
@Entity
@Table(name = "reviews", schema = "mydatabase", catalog = "")
public class Reviews {
    private int id;
    private String review;
    private Date reviewDate;
    private User user;
    private ProductsEntity productsEntity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "review", nullable = true, length = 255)
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Basic
    @Column(name = "reviewDate", nullable = true)
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }


    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "ProductID", nullable = false)
    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviews reviews = (Reviews) o;

        if (id != reviews.id) return false;
        if (review != null ? !review.equals(reviews.review) : reviews.review != null) return false;
        if (reviewDate != null ? !reviewDate.equals(reviews.reviewDate) : reviews.reviewDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (reviewDate != null ? reviewDate.hashCode() : 0);
        return result;
    }
}
