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
<div class="col-lg-6" ></div>
<legend>Account Page</legend>
<div class="container">
    <form class="form-horizontal" action="/account" modelAttribute="userForm" method="post">
        <fieldset>

            <!-- Form Name -->


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
                    <input id="te2" name="textinput"  type="text" placeholder="host" class="form-control input-md" value="${user.email}">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">City:</label>
                <div class="col-md-4">
                    <input id="te1" name="textinput"  type="text" placeholder="host" class="form-control input-md" value="${user.userCity}">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="textinput">Email:</label>
                <div class="col-md-4">
                    <input id="te" name="textinput"  type="text" placeholder="host" class="form-control input-md" value="${user.userState}">

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
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Edit Account</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
<div class="col-lg-6">
    <form class="form-horizontal">

    </form>
</div>

<!-- jQuery -->
<script src="/resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/js/bootstrap.min.js"></script>