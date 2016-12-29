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
            <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
            <tr>
                <th>Product Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Weight</th>
                <th>Description</th>
                <th>Image</th>

                <th>Category</th>


                <th>Update Date</th>

                <th>Stock</th>

                <th>Live</th>

                <th>Unlimited</th>

                <th>Tags</th>

                <th class="text-center">Action</th>
            </tr>
            </thead>
            <c:forEach var="product" items="${products}">

                <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>

                <td>${product.productPrice}</td>
                <td>${product.productWeight}</td>
                <td>${product.productLongDesc}</td>
                <td>${product.productImage}</td>
                <td>${product.productcategoriesByProductCategoryId.categoryName}</td>
                <td>${product.productUpdateDate}</td>
                <td>${product.productStock}</td>
                <td>${product.productLive}</td>
                <td>${product.productUnlimited}</td>
                <td>${product.productTags}</td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>

            </tr>
            </c:forEach>
        </table>
    </div>
</div>