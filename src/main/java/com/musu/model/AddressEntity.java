package com.musu.model;

import javax.persistence.*;

/**
 * Created by Ortayol on 15.01.2017.
 */
@Entity
@Table(name = "Address", schema = "mydatabase", catalog = "")
public class AddressEntity {
    private int addressId;
    private String addressLine;
    private String city;
    private String state;
    private String zip;
    private int phone;
    private String fullName;
    private User user;

    @Id
    @Column(name = "AddressID")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "AddressLine")
    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "Phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Full Name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @ManyToOne
    @JoinColumn(name ="UserID",referencedColumnName = "id",nullable = false)

            public User getUser() {
            return user;
            }

            public void setUser(User user) {
        this.user = user;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (addressId != that.addressId) return false;
        if (phone != that.phone) return false;
        if (addressLine != null ? !addressLine.equals(that.addressLine) : that.addressLine != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (addressLine != null ? addressLine.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }


}
