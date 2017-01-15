<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<div class="container">

    <div class="row carousel-holder">

        <div class="col-md-12">

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
                        <h4 class="pull-right">${product.productPrice}</h4>
                        <h4> <a href="<c:url value='/${product.productcategoriesByProductCategoryId.categoryName}/${product.productName}' />" >${product.productName}</a>

                        </h4>
                        <p>${product.productShortDesc}</p>
                    </div>
                    <div class="ratings">
                        <div class="ratings">
                            <p class="pull-right">${product.reviews.size()} Reviews</p>

                        </div>
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


