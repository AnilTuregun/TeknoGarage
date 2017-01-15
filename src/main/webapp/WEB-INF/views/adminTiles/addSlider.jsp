
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style rel="stylesheet/css">

    #contact{
        padding:10px 0 10px;
    }

    .contact-text{
        margin:45px auto;
    }

    .mail-message-area{
        width:100%;
        padding:0 15px;
    }

    .mail-message{
        width: 100%;
        background:rgba(255,255,255, 0.8) !important;
        -webkit-transition: all 0.7s;
        -moz-transition: all 0.7s;
        transition: all 0.7s;
        margin:0 auto;
        border-radius: 0;
    }

    .not-visible-message{
        height:0px;
        opacity: 0;
    }

    .visible-message{
        height:auto;
        opacity: 1;
        margin:25px auto 0;
    }

    /* Input Styles */

    .form{
        width: 100%;
        padding: 15px;
        background:#f8f8f8;
        border:1px solid rgba(0, 0, 0, 0.075);
        margin-bottom:25px;
        color:#727272 !important;
        font-size:13px;
        -webkit-transition: all 0.4s;
        -moz-transition: all 0.4s;
        transition: all 0.4s;
    }

    .form:hover{
        border:1px solid #30a5ff;
    }

    .form:focus{
        color: white;
        outline: none;
        border:1px solid #30a5ff;
    }

    .textarea{
        height: 200px;
        max-height: 200px;
        max-width: 100%;
    }

    /* Generic Button Styles */

    .button{
        padding:8px 12px;
        background:#0A5175;
        display: block;
        width:120px;
        margin:10px 0 0px 0;
        border-radius:3px;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        transition: all 0.3s;
        text-align:center;
        font-size:0.8em;
        box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
        -moz-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
        -webkit-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    }

    .button:hover{
        background:#8BC3A3;
        color:white;
    }

    /* Send Button Styles */

    .form-btn{
        width:180px;
        display: block;
        height: auto;
        padding:15px;
        color:#fff;
        background:#30a5ff;
        border:none;
        border-radius:3px;
        outline: none;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        transition: all 0.3s;
        margin:auto;
        box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
        -moz-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
        -webkit-box-shadow: 0px 1px 4px rgba(0,0,0, 0.10);
    }

    .form-btn:hover{
        background:#111;
        color: white;
        border:none;
    }

    .form-btn:active{
        opacity: 0.9;
    }
    center{
        margin-top:330px;
    }
    input {
        position: relative;
        z-index: 9999;
    }
</style>
<head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"></head>
<br />
<div class="inner contact" style="padding-left: 550px;padding-top: 100px;">
    <!-- Form Area -->
    <div class="contact-form">
        <!-- Form -->
        <form:form  id="contact-us" method="POST" action="/adminpanel/addslider" modelAttribute="slider">
            <!-- Left Inputs -->
            <div class="col-xs-6 wow animated slideInLeft" data-wow-delay=".5s">
                <!-- Name -->
                <form:label path="productsEntity.productId"/>
                <form:input type="text" name="name" id="name" required="required" class="form" placeholder="Product Id" path="productsEntity.productId" />
                <form:label path="SliderImage"/>

                <form:input  name="mail" id="mail" required="required" class="form" placeholder="Image Path"  path="SliderImage" />
                <form:label path="Active"/>
                <form:input name="subject" id="subject" required="required" class="form" placeholder="Active (0 or 1)"  path="Active" />
            </div><!-- End Left Inputs -->

            <!-- Bottom Submit -->
            <div class="relative fullwidth col-xs-12" style="
    padding-right: 450px;" >
                <!-- Send Button -->
                <button type="submit" id="submit" name="submit" class="form-btn semibold">Save</button>
            </div><!-- End Bottom Submit -->
            <!-- Clear -->
            <div class="clear"></div>
        </form:form>

    </div>
</div>


