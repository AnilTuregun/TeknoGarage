<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/home">
            <img src="/resources/image/logo.png" alt="" />
                </a>
        </div>

        <div class="search-box">
            <form method="GET" action="${contextPath}/searchProduct" class="form-signin">
            <input type="text" class="search-query form-control" placeholder="Search" name="searchProduct" />
            </form>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="${contextPath}/signUp">Sign up</a>
                    </sec:authorize>

                </li>
                <li>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="login" href="<c:url value='/login'/>">Log in</a>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Welcome ${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-cart" role="menu">
                        <li>
                  <span class="item">
                    <span class="item-left">
                        <img src="/resources/image/user_icon.png" alt="" />
                        <span class="item-info">
                            <a href="/account">Account</a>
                        </span>
                    </span>
                </span>
                        </li>
                        <li>
                  <span class="item">
                    <span class="item-left">
                        <img src="/resources/image/orderIcon.png" alt="" />
                        <span class="item-info">
                              <a href="/myOrders">My Orders</a>
                        </span>
                    </span>
                </span>
                        </li>
                        <li>
                  <span class="item">
                    <span class="item-left">
                        <img src="/resources/image/shoppinCartIcon.png" alt="" />
                        <span class="item-info">
                            <a href="/cart">Shopping Cart</a>
                        </span>
                    </span>
                </span>
                        </li>
                        <li class="divider"></li>
                        <li><a class="login" href="<c:url value='/loggedout'/>">Log out</a></li>
                    </ul>
                </li>
                    </sec:authorize>

                </li>

                <li>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <c:if test="${pageContext.request.userPrincipal.name =='adminadmin'}">
                        <li><a href="/adminpanel">Admin Panel</a> </li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name !='adminadmin'}">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="glyphicon glyphicon-shopping-cart"></span> ${shoppingCart.size()} - Items<span class="caret"></span></a>
                            <ul class="dropdown-menu dropdown-cart" role="menu">
                                <c:if test="${pageContext.request.userPrincipal.name !=null}">
                                <c:forEach var="cart" items="${shoppingCart}">
                                <li>
                  <span class="item">
                    <span class="item-left">
                        <img src="${cart.product.productImage}"  alt="" style="width: 72px; height: 72px;"/>
                        <span class="item-info">
                            <span>${cart.product.productName}</span>
                            <span>${cart.product.productPrice}</span>
                        </span>
                    </span>
                </span>
                                </li>
                                </c:forEach>
                                    </c:if>
                                <li class="divider"></li>
                                <li><a class="text-center" href="/cart">View Cart</a></li>
                            </ul>
                            </c:if>
                        </li>

                    </ul>
            </ul>

            </li>
            </ul>
        </div>

        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>