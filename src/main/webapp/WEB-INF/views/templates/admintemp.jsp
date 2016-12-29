<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
    <link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet"></link>


    <script src="js/chart.min.js"></script>
    <script src="js/chart-data.js"></script>
    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/script/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/script/lumino.glyphs.js.js"></script>
    <tiles:insertAttribute name="includes"></tiles:insertAttribute>


</head>
<body>
<div class="content">
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<hr/>
</body>
</html>