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

	<link href="${pageContext.request.contextPath}/resources/css/shop-productpage.css" rel="stylesheet">


	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

	<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet">

	<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>

<tiles:insertAttribute name="includes"></tiles:insertAttribute>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div class="col-md-3">
	</div>

		<div class="col-md-9">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>

		<hr/>
	</div>
</div>
<div style="background-color:#3654ff;">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>