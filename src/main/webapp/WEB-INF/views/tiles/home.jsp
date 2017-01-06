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


            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner">
                            <c:forEach var="slider" items="${sliders}">
                            <div class="item">

                                <img class="slide-image" src="../../..${slider.sliderImage}" alt="">

                            </div>
                            </c:forEach>
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
                        <a href="<c:url value='/${product.productcategoriesByProductCategoryId.categoryName}/${product.productName}' />">
                        <img src="${product.productImage}" alt="">
                        </a>
                        <div class="caption">

                            <h4><a href="${contextPath}/${product.productcategoriesByProductCategoryId.categoryName}/${product.productName}">${product.productName}</a>
                            </h4>

                            <h4 >${product.productPrice}</h4>
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
           


            </div>

    </div>
<!-- /.container -->



<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


