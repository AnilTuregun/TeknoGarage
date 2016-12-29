<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.12.2016
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<div class="container">
    <form class="form-horizontal">
        <fieldset>

            <!-- Form Name -->
            <legend>My Profile-> user profile->exhibition</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Name:</label>
                <div class="col-md-4">
                    <input id="textinput" name="textinput" type="text" placeholder="trade show name" value="${user.userFirstname} ${user.userLastname}" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Password:</label>
                <div class="col-md-4">
                    <input id="tex" name="textinput" type="text" placeholder="date attended" value="${user.password}"  class="form-control input-md" >

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Email:</label>
                <div class="col-md-4">
                    <input id="te" name="textinput"  type="text" placeholder="host" class="form-control input-md" value="${user.email}">

                </div>
            </div>



            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="textarea">Adress:</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="textarea" name="textarea" value="${user.userAdress}">${user.userAdress}</textarea>
                </div>
            </div>



            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="singlebutton"></label>
                <div class="col-md-4">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">submit</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
<div class="container-fluid">
    <div class="col-md-12 product-info">
        <ul id="myTab" class="nav nav-tabs nav_tabs">

            <li class="active"><a href="#service-one" data-toggle="tab">Orders</a></li>
            <li><a href="#service-three" data-toggle="tab">ShoppingCart</a></li>

        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="service-one">

                <section class="container product-info">
                    <div class="col-lg-6">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th class="text-center">Price</th>
                                <th class="text-center">Total</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="orders" items="${user.ordersEntities}">
                                <tr class="productRow">

                                    <td class="col-sm-8 col-md-6">
                                        <div class="media">
                                            <div class="media-body">
                                                <h4 class="media-heading"><a href="#">${orders.orderEmail}</a></h4>

                                                <span>Status: </span><span class="text-success"><strong>In Stock=${orders.orderAmount}</strong></span>
                                            </div>
                                        </div></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>Your Orders</div>
                </section>

            </div>

            <div class="tab-pane fade" id="service-three">
               ShoppinCart
        </div>
        </div>
        <hr>
    </div>
</div>

<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>