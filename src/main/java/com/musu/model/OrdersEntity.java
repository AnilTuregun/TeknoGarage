package com.musu.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "orders", schema = "mydatabase", catalog = "")
public class OrdersEntity {
    private int orderId;
    private double orderAmount;
    private String orderShipName;
    private String orderShipAddress;
    private String orderCity;
    private String orderState;
    private String orderZip;
    private String orderPhone;
    private double orderShipping;
    private String orderEmail;
    private Timestamp orderDate;
    private byte orderShipped;
    private String orderTrackingNumber;

    @Id
    @Column(name = "OrderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "OrderAmount")
    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Basic
    @Column(name = "OrderShipName")
    public String getOrderShipName() {
        return orderShipName;
    }

    public void setOrderShipName(String orderShipName) {
        this.orderShipName = orderShipName;
    }

    @Basic
    @Column(name = "OrderShipAddress")
    public String getOrderShipAddress() {
        return orderShipAddress;
    }

    public void setOrderShipAddress(String orderShipAddress) {
        this.orderShipAddress = orderShipAddress;
    }

    @Basic
    @Column(name = "OrderCity")
    public String getOrderCity() {
        return orderCity;
    }

    public void setOrderCity(String orderCity) {
        this.orderCity = orderCity;
    }

    @Basic
    @Column(name = "OrderState")
    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Basic
    @Column(name = "OrderZip")
    public String getOrderZip() {
        return orderZip;
    }

    public void setOrderZip(String orderZip) {
        this.orderZip = orderZip;
    }

    @Basic
    @Column(name = "OrderPhone")
    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    @Basic
    @Column(name = "OrderShipping")
    public double getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(double orderShipping) {
        this.orderShipping = orderShipping;
    }

    @Basic
    @Column(name = "OrderEmail")
    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    @Basic
    @Column(name = "OrderDate")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "OrderShipped")
    public byte getOrderShipped() {
        return orderShipped;
    }

    public void setOrderShipped(byte orderShipped) {
        this.orderShipped = orderShipped;
    }

    @Basic
    @Column(name = "OrderTrackingNumber")
    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (Double.compare(that.orderAmount, orderAmount) != 0) return false;
        if (Double.compare(that.orderShipping, orderShipping) != 0) return false;
        if (orderShipped != that.orderShipped) return false;
        if (orderShipName != null ? !orderShipName.equals(that.orderShipName) : that.orderShipName != null)
            return false;
        if (orderShipAddress != null ? !orderShipAddress.equals(that.orderShipAddress) : that.orderShipAddress != null)
            return false;
        if (orderCity != null ? !orderCity.equals(that.orderCity) : that.orderCity != null) return false;
        if (orderState != null ? !orderState.equals(that.orderState) : that.orderState != null) return false;
        if (orderZip != null ? !orderZip.equals(that.orderZip) : that.orderZip != null) return false;
        if (orderPhone != null ? !orderPhone.equals(that.orderPhone) : that.orderPhone != null) return false;
        if (orderEmail != null ? !orderEmail.equals(that.orderEmail) : that.orderEmail != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (orderTrackingNumber != null ? !orderTrackingNumber.equals(that.orderTrackingNumber) : that.orderTrackingNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        temp = Double.doubleToLongBits(orderAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (orderShipName != null ? orderShipName.hashCode() : 0);
        result = 31 * result + (orderShipAddress != null ? orderShipAddress.hashCode() : 0);
        result = 31 * result + (orderCity != null ? orderCity.hashCode() : 0);
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (orderZip != null ? orderZip.hashCode() : 0);
        result = 31 * result + (orderPhone != null ? orderPhone.hashCode() : 0);
        temp = Double.doubleToLongBits(orderShipping);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (orderEmail != null ? orderEmail.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (int) orderShipped;
        result = 31 * result + (orderTrackingNumber != null ? orderTrackingNumber.hashCode() : 0);
        return result;
    }
}
