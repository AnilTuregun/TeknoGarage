<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <div class="container">
        <div class="row">

            <form:form action="/addProduct" method="POST" modelAttribute="productForm">
                <div class="form-group">
                    <legend>Product Request</legend>


                <table border="0">
                    <tr>
                        <td colspan="2" align="center"><h2>Order</h2></td>
                    </tr>
                    <tr>
                        <td>User Name:</td>
                        <td><form:input path="productName" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><form:input path="productPrice" /></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><form:input path="productWeight" /></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><form:input path="productLongDesc" /></td>
                    </tr>

                    <tr>
                        <td>CategoriName:</td>
                        <td>
                            <form:select  path="productcategoriesByProductCategoryId.categoryName">
                                <form:option value="NONE"> --SELECT--</form:option>
                                <form:options items="${categoriList}"></form:options>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Add Product" /></td>
                    </tr>

                </table>
            </form:form>
        </div>
    </div>
