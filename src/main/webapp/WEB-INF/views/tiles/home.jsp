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
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <c:forEach var="slider" items="${sliders}" varStatus="statuss" >
                    <c:choose>
                        <c:when test="${statuss.first}">
                            <li data-target="#carousel-example-generic" data-slide-to="${statuss.index}" class="active"></li>
                        </c:when>
                        <c:otherwise>
                            <li data-target="#carousel-example-generic" data-slide-to="${statuss.index}"></li>
                        </c:otherwise>

                    </c:choose>
                </c:forEach>


            </ol>
            <div class="carousel-inner">

                <c:forEach var="slider" items="${sliders}" varStatus="statuss" >

                <c:choose>
                <c:when test="${statuss.first}">
                <div class="item active">
                    </c:when>

                    <c:otherwise>
                    <div class="item">
                        </c:otherwise>
                        </c:choose>

                        <a href="${slider.productsEntity.productcategoriesByProductCategoryId.categoryName}/${slider.productsEntity.productName}">
                            <img class="slide-image" src="../../..${slider.sliderImage}" alt="">
                            <span style="
    /* position: absolute; */
    left: 500px;
    top: 220px;
    position: absolute;
    color: red;
    font-size: x-large;
    /* right: 600px; */
">  ${slider.productsEntity.productPrice}</span>
                        </a>

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
                        <p class="pull-right"> reviews</p>

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