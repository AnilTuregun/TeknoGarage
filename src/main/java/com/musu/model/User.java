package com.musu.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String passwordConfirm;
    private Set<Role> roles;
    private Set<ShoppingCart> shoppingCarts;
    private Set<Reviews> reviews;
    private String userFirstname;
    private String userLastname;
    private String userCity;
    private String userState;
    private Integer userZip;
    private Byte userEmailVerified;
    private Timestamp userRegistrationDate;
    private Integer userVerificationCode;
    private Integer userPhone;

    private Set<OrdersEntity> ordersEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<OrdersEntity> getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(Set<OrdersEntity> ordersEntities) {
        this.ordersEntities = ordersEntities;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Reviews> reviews) {
        this.reviews = reviews;
    }

    @Basic
    @Column(name = "userFirstname")
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Basic
    @Column(name = "userLastname")
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Basic
    @Column(name = "userCity")
    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    @Basic
    @Column(name = "userState")
    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Basic
    @Column(name = "userZip")
    public Integer getUserZip() {
        return userZip;
    }

    public void setUserZip(Integer userZip) {
        this.userZip = userZip;
    }

    @Basic
    @Column(name = "userEmailVerified")
    public Byte getUserEmailVerified() {
        return userEmailVerified;
    }

    public void setUserEmailVerified(Byte userEmailVerified) {
        this.userEmailVerified = userEmailVerified;
    }

    @Basic
    @Column(name = "userRegistrationDate")
    public Timestamp getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Timestamp userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    @Basic
    @Column(name = "userVerificationCode")
    public Integer getUserVerificationCode() {
        return userVerificationCode;
    }

    public void setUserVerificationCode(Integer userVerificationCode) {
        this.userVerificationCode = userVerificationCode;
    }

    @Basic
    @Column(name = "userPhone")
    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;


        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userFirstname != null ? !userFirstname.equals(user.userFirstname) : user.userFirstname != null)
            return false;
        if (userLastname != null ? !userLastname.equals(user.userLastname) : user.userLastname != null) return false;
        if (userCity != null ? !userCity.equals(user.userCity) : user.userCity != null) return false;
        if (userState != null ? !userState.equals(user.userState) : user.userState != null) return false;
        if (userZip != null ? !userZip.equals(user.userZip) : user.userZip != null) return false;
        if (userEmailVerified != null ? !userEmailVerified.equals(user.userEmailVerified) : user.userEmailVerified != null)
            return false;
        if (userRegistrationDate != null ? !userRegistrationDate.equals(user.userRegistrationDate) : user.userRegistrationDate != null)
            return false;
        if (userVerificationCode != null ? !userVerificationCode.equals(user.userVerificationCode) : user.userVerificationCode != null)
            return false;
        if (userPhone != null ? !userPhone.equals(user.userPhone) : user.userPhone != null) return false;

        return true;
    }


}
