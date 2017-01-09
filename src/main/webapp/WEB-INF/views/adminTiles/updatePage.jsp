<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-10 ">
            <form:form action="/adminPanel/editProduct" method="POST" cssClass="form-horizontal" modelAttribute="editproductForm">
                <div class="form-group">
                    <legend>Product Request</legend>



                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productPrice">Select Product Categori </label>
                        <div class="col-md-4">
                            <form:select  path="productcategoriesByProductCategoryId.categoryName">
                                <form:option value="NONE"> --SELECT--</form:option>
                                <form:options items="${categoriList}"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productName">Product SKU:</label>
                            <div class="col-md-4">
                            <form:input path="productSku" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productName">Product Name:</label>
                        <div class="col-md-4">
                            <form:input path="productName" />
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                    <label class="col-md-4 control-label" for="productPrice">Product Price </label>
                    <div class="col-md-4">
                        <form:input path="productPrice" />
                    </div>
                </div>
                    <div class="form-group">
                    <label class="col-md-4 control-label" for="productPrice">Product Weight: </label>
                    <div class="col-md-4">
                        <form:input path="productWeight" />
                    </div>
                </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productPrice">Product Stock: </label>
                        <div class="col-md-4">
                            <form:input path="productStock" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productPrice">Product Description </label>
                        <div class="col-md-4">
                            <form:textarea path="productLongDesc" />
                        </div>
                    </div>
                    <div class="col-lg-12 form-group">
                        <label class="col-md-4 control-label" for="productImage">Product Image</label>
                        <div class="col-sm-4">
                            <form:input type="file" path="productImage"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="productPrice">Product Tags: </label>
                        <div class="col-md-4">
                            <form:input path="productTags" />
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="saveBtn"></label>
                        <div class="col-md-8">
                            <button id="saveBtn" type="submit" name="button1id" class="btn btn-success">Save</button>
                            <button id="cancelBtn" name="button2id" class="btn btn-danger">Cancel</button>
                        </div>
                    </div>
                </div>
                </form:form>


</div>