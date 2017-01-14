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
    <div align="center" class="order-container" style="max-width:800px ;min-height: 200px; padding:10px 10px 10px 10px" >


        <div align="left" class="address-price" style="float:left ; max-width:200px ">

            Order Date:${order.orderDate}<br>
            Oder No:${order.orderId} <br>
            To: Mustafa Ortayol<br>
            Address: Nuripaşa Mah 64-4  <br>
            Amount:143,92 TL


        </div>
        Lumberjack 6W Eagle Hı Erkek Bot A3373352


        <div align="right" class="order-detail" style="float:right ; max-width:200px ">


            <a style=" display: block;
    width: 85px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;"   href="/myOrders/${order.orderId}">Order Detail</a>
        </div>

    </div>



        </c:forEach>
    </table>










</div>

