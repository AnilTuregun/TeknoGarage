<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<p class="lead">Shop Name</p>
<div class="list-group">
    <c:forEach var="category" items="${category}">
        <a class="list-group-item" href="/categories/${category.categoryName}">${category.categoryName}</a>
    </c:forEach>
</div>
<div class="ad">
    <img src="intel.jpg" alt="">

</div>

