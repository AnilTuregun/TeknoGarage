package com.musu.account.model;

import javax.persistence.*;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "orderdetails", schema = "mydatabase", catalog = "")
public class OrderdetailsEntity {
    private int detailId;
    private String detailName;
    private double detailPrice;
    private String detailSku;
    private int detailQuantity;

    @Id
    @Column(name = "DetailID")
    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    @Basic
    @Column(name = "DetailName")
    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    @Basic
    @Column(name = "DetailPrice")
    public double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(double detailPrice) {
        this.detailPrice = detailPrice;
    }

    @Basic
    @Column(name = "DetailSKU")
    public String getDetailSku() {
        return detailSku;
    }

    public void setDetailSku(String detailSku) {
        this.detailSku = detailSku;
    }

    @Basic
    @Column(name = "DetailQuantity")
    public int getDetailQuantity() {
        return detailQuantity;
    }

    public void setDetailQuantity(int detailQuantity) {
        this.detailQuantity = detailQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailsEntity that = (OrderdetailsEntity) o;

        if (detailId != that.detailId) return false;
        if (Double.compare(that.detailPrice, detailPrice) != 0) return false;
        if (detailQuantity != that.detailQuantity) return false;
        if (detailName != null ? !detailName.equals(that.detailName) : that.detailName != null) return false;
        if (detailSku != null ? !detailSku.equals(that.detailSku) : that.detailSku != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = detailId;
        result = 31 * result + (detailName != null ? detailName.hashCode() : 0);
        temp = Double.doubleToLongBits(detailPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (detailSku != null ? detailSku.hashCode() : 0);
        result = 31 * result + detailQuantity;
        return result;
    }
}
