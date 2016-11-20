package com.musu.account.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 19.11.2016.
 */
@Entity
@Table(name = "users", schema = "mydatabase", catalog = "")
public class UsersEntity {
    private int userId;
    private String userEmail;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String userState;
    private String userZip;
    private Byte userEmailVerified;
    private Timestamp userRegistrationDate;
    private String userVerificationCode;
    private String userIp;
    private String userPhone;
    private String userAddress;

    @Id
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserEmail")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "UserPassword")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "UserFirstName")
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Basic
    @Column(name = "UserLastName")
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "UserCity")
    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Basic
    @Column(name = "UserState")
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Basic
    @Column(name = "UserZip")
    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    @Basic
    @Column(name = "UserEmailVerified")
    public Byte getUserEmailVerified() {
        return userEmailVerified;
    }

    public void setUserEmailVerified(Byte userEmailVerified) {
        this.userEmailVerified = userEmailVerified;
    }

    @Basic
    @Column(name = "UserRegistrationDate")
    public Timestamp getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Timestamp userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    @Basic
    @Column(name = "UserVerificationCode")
    public String getUserVerificationCode() {
        return userVerificationCode;
    }

    public void setUserVerificationCode(String userVerificationCode) {
        this.userVerificationCode = userVerificationCode;
    }

    @Basic
    @Column(name = "UserIP")
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Basic
    @Column(name = "UserPhone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "UserAddress")
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
        if (userCity != null ? !userCity.equals(that.userCity) : that.userCity != null) return false;
        if (userState != null ? !userState.equals(that.userState) : that.userState != null) return false;
        if (userZip != null ? !userZip.equals(that.userZip) : that.userZip != null) return false;
        if (userEmailVerified != null ? !userEmailVerified.equals(that.userEmailVerified) : that.userEmailVerified != null)
            return false;
        if (userRegistrationDate != null ? !userRegistrationDate.equals(that.userRegistrationDate) : that.userRegistrationDate != null)
            return false;
        if (userVerificationCode != null ? !userVerificationCode.equals(that.userVerificationCode) : that.userVerificationCode != null)
            return false;
        if (userIp != null ? !userIp.equals(that.userIp) : that.userIp != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userAddress != null ? !userAddress.equals(that.userAddress) : that.userAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userCity != null ? userCity.hashCode() : 0);
        result = 31 * result + (userState != null ? userState.hashCode() : 0);
        result = 31 * result + (userZip != null ? userZip.hashCode() : 0);
        result = 31 * result + (userEmailVerified != null ? userEmailVerified.hashCode() : 0);
        result = 31 * result + (userRegistrationDate != null ? userRegistrationDate.hashCode() : 0);
        result = 31 * result + (userVerificationCode != null ? userVerificationCode.hashCode() : 0);
        result = 31 * result + (userIp != null ? userIp.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        return result;
    }
}
