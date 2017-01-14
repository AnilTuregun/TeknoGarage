<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.12.2016
  Time: 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div align="center">









    <form:form action="/checkOut" method="POST" modelAttribute="order">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Order</h2></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><form:input path="orderShipName" /></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><form:label path="orderAmount" >${totalAmount}</form:label></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><form:input path="orderEmail" /></td>
            </tr>
            <tr>
                <td>Address Line:</td>
                <td><form:input path="orderShipAddress" /></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><form:input path="orderCity" /></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><form:input path="orderState" /></td>
            </tr> <tr>
            <td>Zip:</td>
            <td><form:input path="orderZip" /></td>
        </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="orderPhone" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form:form>
</div>