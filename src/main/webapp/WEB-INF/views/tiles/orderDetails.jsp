<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Ortayol
  Date: 12.01.2017
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">

    <table>

        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Image</th>

        </tr>
        <c:forEach var="orderDetail" items="${orderDetails}">
            <tr>
                <td>${orderDetail.detailName}</td>
                <td>${orderDetail.detailPrice} </td>

                <td>${orderDetail.detailQuantity}</td>
                <td><img src="${orderDetail.productsEntity.productImage}"> </td>

            </tr>
        </c:forEach>
    </table>










</div>

