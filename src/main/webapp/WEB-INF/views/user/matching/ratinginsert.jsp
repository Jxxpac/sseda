<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평점등록</title>
<link rel="stylesheet" href="/css/rating.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/service.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="ratinginsert">
		<form method="post" action="/ma/insert">
		<c:set value="${id }" var="id" />
			<input type="text" name="id" value="${id }" readonly>		
			<input type="number" name="rating" placeholder="점수" max="10" min="0"><br>
			<input type="hidden" name="no" value="${no }">
			<input type="submit" value="등록">
		</form>
	</div>	
</div>	
	<%@include file="../footer.jsp" %>
</body>
</html>