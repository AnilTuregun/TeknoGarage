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
    <table>

        <tr>
            <th>Order Number</th>
            <th>Date</th>
        </tr>
        <tr>
            <td>${order.orderId}</td>
            <td>${order.orderDate} </td>
        </tr>
    </table>






        </c:forEach>
    


</div>

