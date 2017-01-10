<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24.12.2016
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <div style="margin-left: 120px" >
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>Username:</th>
                <th>User First Name:</th>
                <th>User Last Name:</th>
                <th>User Email:</th>
                <th>User City:</th>
                <th>User Phone:</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <c:forEach var="user" items="${users}">

                <tr>
                    <td>${user.username}</td>
                <td>${user.userFirstname}</td>
                <td>${user.userLastname}</td>
                <td>${user.email}</td>
                <td>${user.userCity}</td>
                <td>${user.userPhone}</td>
                <td class="text-center"><a href="/deleteUser/${user.username}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>