<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Ortayol
  Date: 14.01.2017
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<div class="container">
    <div style="margin-left: 120px" >
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Image:</th>
                <th>Product Name:</th>
                <th>Product Id:</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach var="slider" items="${sliders}">

                <tr>
                    <td><img src="${slider.sliderImage}" style="width: 50%;"></td>
                    <td>${slider.productsEntity.productName}</td>
                    <td>${slider.productsEntity.productId}</td>
                    <td class="text-center"><a href="/adminpanel/deleteslider/${slider.sliderId}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
                    </tr>
            </c:forEach>
        </table>
    </div>

</div>