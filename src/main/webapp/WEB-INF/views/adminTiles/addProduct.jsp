<%--
  Created by IntelliJ IDEA.
  User: Ortayol
  Date: 29.12.2016
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form modelAttribute="productForm"  method="post">
    <h2 class="form-signin-heading">Add Product</h2>
    <spring:bind path="ProductSKU">

            <form:input type="text" path="username" class="form-control" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>

    </spring:bind>
    <spring:bind path="email">

            <form:input type="email" path="email" class="form-control" placeholder="email"></form:input>
            <form:errors path="email"></form:errors>

    </spring:bind>

    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
            <form:errors path="password"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="passwordConfirm">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="passwordConfirm" class="form-control"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="passwordConfirm"></form:errors>
        </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
</form:form>