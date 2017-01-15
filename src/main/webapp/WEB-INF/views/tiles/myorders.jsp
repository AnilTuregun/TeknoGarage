<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ortayol
  Date: 12.01.2017
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">

    <c:forEach var="order" items="${orders}">
    <div align="center" class="order-container" style="    max-width: 800px;
    min-height: 200px;
    background-color: rgb(236, 244, 249);
    border-left: 6px solid #4e9caf;
    padding: 10px 10px 10px 10px;
    margin: 10px 10px 10px 10px;
    border-radius: 7px;" >


        <div align="left" class="address-price" style="float:left ; max-width:200px ">

            <strong>   Order Date:</strong>${order.orderDate}<br>
            <strong>Order No:</strong>${order.orderId} <br>
            <strong> To:</strong>${order.orderShipName}<br>
            <strong>Address:</strong> ${order.orderShipAddress}  <br>
            <strong> Amount:</strong>${order.orderAmount}


        </div>
        <ul style="list-style-type:disc">
        <c:forEach var="orderdetail" items="${orderdetails}">
          <c:if test="${order.orderId}=${orderdetail.ordersEntity.orderId}">
            <li>${orderdetail.detailName}</li>
          </c:if>
        </c:forEach>
        </ul>


        <div align="right" class="order-detail" style="float:right ; max-width:200px ">


            <a style=" display: block;
    width: 85px;

 background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;"   href="/myOrders/${order.orderId}">Order Detail</a>
        </div>

    </div>



        </c:forEach>











</div>

