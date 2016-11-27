<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.11.2016
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>



<!-- Navigation -->

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <p class="lead">Shop Name</p>
            <div class="list-group">

                <c:forEach var="category" items="${category}">
                    <a class="list-group-item" href="<c:url value='/category/${category.categoryId}' />" >${category.categoryName}</a>
                </c:forEach>
            </div>
            <div class="ad">
                <img src="intel.jpg" alt="">

            </div>
        </div>

        <div class="col-md-9">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="../../../resources/image/samsung.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="../../../resources/image/800.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="../../../resources/image/tel.png" alt="">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>

            <div class="row">
                <c:forEach var="product" items="${products}">

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="${product.productImage}" alt="">
                        <div class="caption">
                            <h4 class="pull-right">${product.productPrice}</h4>
                            <h4><a href="#">${product.productName}</a>
                            </h4>
                            <p>${product.productShortDesc} <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                        </div>
                        <div class="ratings">
                            <p class="pull-right">15 reviews</p>
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                            </p>
                        </div>
                    </div>
                </div>
                </c:forEach>
           

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <h4><a href="#">Like this template?</a>
                    </h4>
                    <p>If you like this template, then check out <a target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this tutorial</a> on how to build a working review system for your online store!</p>
                    <a class="btn btn-primary" target="_blank" href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">View Tutorial</a>
                </div>

            </div>

        </div>

    </div>

</div>
<!-- /.container -->



<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


